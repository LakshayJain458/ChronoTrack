package org.example.tt_backened.Mappers.Impl;

import org.example.tt_backened.DTO.TaskDto;
import org.example.tt_backened.Entities.Tasks;
import org.example.tt_backened.Mappers.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Tasks fromDto(TaskDto taskDto) {
        return new Tasks(
                taskDto.id(),
                taskDto.title(),
                taskDto.description(),
                taskDto.dueDate(),
                taskDto.priority(),
                taskDto.status(),
                null,
                null,
                null
        );
    }

    @Override
    public TaskDto toDto(Tasks tasks) {
        return new TaskDto(
                tasks.getId(),
                tasks.getTitle(),
                tasks.getDescription(),
                tasks.getDueDate(),
                tasks.getStatus(),
                tasks.getPriority()
        );
    }
}
