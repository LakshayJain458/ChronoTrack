package org.example.tt_backened.DTO;

import org.example.tt_backened.Entities.TaskPriority;
import org.example.tt_backened.Entities.TaskStatus;
import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDateTime dueDate,
        TaskStatus status,
        TaskPriority priority
) {
}
