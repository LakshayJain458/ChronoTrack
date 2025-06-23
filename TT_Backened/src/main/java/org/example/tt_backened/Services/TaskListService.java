package org.example.tt_backened.Services;

import org.example.tt_backened.Entities.TaskLists;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskListService {
    List<TaskLists> listTaskLists();

    TaskLists createTaskList(TaskLists taskLists);

    Optional<TaskLists> getTaskList(UUID id);

    TaskLists updateTaskList(UUID id, TaskLists taskLists);

    void deleteTaskList(UUID id);
}
