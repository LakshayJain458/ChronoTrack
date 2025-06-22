package org.example.tt_backened.Mappers;

import org.example.tt_backened.DTO.TaskListDto;
import org.example.tt_backened.Entities.TaskLists;

public interface TaskListMapper {

    TaskLists fromDto(TaskListDto taskListDto);

    TaskListDto toDto(TaskLists taskLists);
}
