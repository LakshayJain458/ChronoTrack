package org.example.tt_backened.Services.Impl;

import jakarta.transaction.Transactional;
import org.example.tt_backened.Entities.TaskLists;
import org.example.tt_backened.Entities.TaskPriority;
import org.example.tt_backened.Entities.TaskStatus;
import org.example.tt_backened.Entities.Tasks;
import org.example.tt_backened.Repositories.TaskListsRepo;
import org.example.tt_backened.Repositories.TasksRepo;
import org.example.tt_backened.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TasksRepo tasksRepo;

    @Autowired
    private TaskListsRepo taskListsRepo;

    @Override
    public List<Tasks> GetAllTasks(UUID id) {
        return tasksRepo.findByTaskListId(id);
    }

    @Transactional
    @Override
    public Tasks CreateTask(UUID taskListId, Tasks task) {
        if (task.getId() != null) {
            throw new IllegalArgumentException("Task id is already set");
        }
        if (task.getTitle() == null || task.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Task title is empty");
        }
        TaskPriority taskPriority = Optional.ofNullable(task.getPriority())
                .orElse(TaskPriority.MEDIUM);
        TaskStatus taskStatus = TaskStatus.OPEN;
        TaskLists taskLists = taskListsRepo.findById(taskListId).orElseThrow(() -> new IllegalArgumentException("Task list not found"));
        LocalDateTime createdAt = LocalDateTime.now();
        Tasks tasks = new Tasks(
                null,
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                taskPriority,
                taskStatus,
                createdAt,
                createdAt,
                taskLists
        );
        return tasksRepo.save(tasks);
    }

    @Override
    public Optional<Tasks> GetTaskById(UUID TaskId, UUID TaskListId) {
        return tasksRepo.findByTaskListIdAndId(TaskListId, TaskId);
    }

    @Transactional
    @Override
    public Tasks UpdateTask(UUID TaskListId, UUID TaskId, Tasks task) {
        if (task.getId() == null) {
            throw new IllegalArgumentException("Task must have an id");
        }
        if (!Objects.equals(TaskId, task.getId())) {
            throw new IllegalArgumentException("Task id's do not match");
        }
        if (task.getPriority() == null) {
            throw new IllegalArgumentException("Task priority is null");
        }
        if (task.getStatus() == null) {
            throw new IllegalArgumentException("Task status is null");
        }
        Tasks existingTask = tasksRepo.findByTaskListIdAndId(TaskListId, TaskId).orElseThrow(() -> new IllegalArgumentException("Task not found"));
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setDueDate(task.getDueDate());
        existingTask.setPriority(task.getPriority());
        existingTask.setStatus(task.getStatus());
        existingTask.setUpdated(LocalDateTime.now());
        return tasksRepo.save(existingTask);
    }

    @Transactional
    @Override
    public void DeleteTask(UUID TaskId, UUID TaskListId) {
        tasksRepo.deleteByTaskListIdAndId(TaskListId, TaskId);
    }

}
