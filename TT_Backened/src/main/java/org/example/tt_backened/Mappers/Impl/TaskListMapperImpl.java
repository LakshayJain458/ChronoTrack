package org.example.tt_backened.Mappers.Impl;

import org.example.tt_backened.DTO.TaskListDto;
import org.example.tt_backened.Entities.TaskLists;
import org.example.tt_backened.Entities.TaskStatus;
import org.example.tt_backened.Entities.Tasks;
import org.example.tt_backened.Mappers.TaskListMapper;
import org.example.tt_backened.Mappers.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class TaskListMapperImpl implements TaskListMapper {

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public TaskLists fromDto(TaskListDto taskListDto) {
        return new TaskLists(
                taskListDto.id(),
                taskListDto.title(),
                taskListDto.description(),
                null,
                null,
                Optional.ofNullable(taskListDto.tasks())
                        .map(tasks -> tasks.stream()
                                .map(taskMapper::fromDto)
                                .toList()
                        ).orElse(null)
        );
    }

    @Override
    public TaskListDto toDto(TaskLists taskLists) {
        return new TaskListDto(
                taskLists.getId(),
                taskLists.getTitle(),
                taskLists.getDescription(),
                Optional.ofNullable(taskLists.getTasks())
                        .map(List::size)
                        .orElse(0),
                CalculateTaskListCount(taskLists.getTasks()),
                Optional.ofNullable(taskLists.getTasks())
                        .map(tasks -> tasks.stream()
                                .map(taskMapper::toDto).toList())
                        .orElse(null)
        );
    }

    private Double CalculateTaskListCount(List<Tasks> tasks) {
        if (tasks == null || tasks.isEmpty()) {
            return 0.0;
        }
        long closedTasks = tasks.stream().filter(task -> TaskStatus.CLOSED == task.getStatus()).count();
        return (double) closedTasks / tasks.size();
    }
}
