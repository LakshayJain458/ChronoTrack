package org.example.tt_backened.Mappers;

import org.example.tt_backened.DTO.TaskDto;
import org.example.tt_backened.Entities.Tasks;

public interface TaskMapper {
    Tasks fromDto(TaskDto taskDto);

    TaskDto toDto(Tasks tasks);
}
