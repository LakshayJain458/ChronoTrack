package org.example.tt_backened.Services;

import org.example.tt_backened.Entities.Tasks;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskService {
    List<Tasks> GetAllTasks(UUID id);

    Tasks CreateTask(UUID taskListId, Tasks task);

    Optional<Tasks> GetTaskById(UUID TaskId, UUID TaskListId);

    Tasks UpdateTask(UUID TaskListId, UUID TaskId, Tasks task);

    void DeleteTask(UUID TaskId, UUID TaskListId);
}
