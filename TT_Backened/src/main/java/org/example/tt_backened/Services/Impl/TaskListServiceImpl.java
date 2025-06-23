package org.example.tt_backened.Services.Impl;

import jakarta.transaction.Transactional;
import org.example.tt_backened.Entities.TaskLists;
import org.example.tt_backened.Repositories.TaskListsRepo;
import org.example.tt_backened.Services.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskListServiceImpl implements TaskListService {

    @Autowired
    private TaskListsRepo taskListsRepo;

    @Override
    public List<TaskLists> listTaskLists() {
        return taskListsRepo.findAll();
    }

    @Override
    public TaskLists createTaskList(TaskLists taskList) {
        if (taskList.getId() != null) {
            throw new IllegalArgumentException("TaskLists id already exists");
        }
        if (taskList.getTitle() == null || taskList.getTitle().isBlank()) {
            throw new IllegalArgumentException("TaskLists title should not be blank");
        }
        LocalDateTime time = LocalDateTime.now();
        return taskListsRepo.save(new TaskLists(
                null,
                taskList.getTitle(),
                taskList.getDescription(),
                time,
                time,
                null
        ));
    }

    @Override
    public Optional<TaskLists> getTaskList(UUID id) {
        return taskListsRepo.findById(id);
    }

    @Transactional
    @Override
    public TaskLists updateTaskList(UUID id, TaskLists taskLists) {
        if (taskLists.getId() == null) {
            throw new IllegalArgumentException("TaskLists id should not be null");
        }
        if (!Objects.equals(id, taskLists.getId())) {
            throw new IllegalArgumentException("TaskLists id does not match");
        }
        TaskLists existingTaskList = taskListsRepo.findById(id).orElseThrow(
                () -> new IllegalArgumentException("TaskLists not found"));
        existingTaskList.setTitle(taskLists.getTitle());
        existingTaskList.setDescription(taskLists.getDescription());
        existingTaskList.setUpdated(LocalDateTime.now());
        return taskListsRepo.save(existingTaskList);

    }

    @Override
    public void deleteTaskList(UUID id) {
        taskListsRepo.deleteById(id);
    }
}
