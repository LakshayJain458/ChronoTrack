package org.example.tt_backened.Controller;

import org.example.tt_backened.DTO.TaskDto;
import org.example.tt_backened.Entities.Tasks;
import org.example.tt_backened.Mappers.TaskMapper;
import org.example.tt_backened.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/task_lists/{taskList_id}/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskMapper taskMapper;

    @GetMapping
    public List<TaskDto> getTaskList(@PathVariable("taskList_id") UUID id) {
        return taskService.GetAllTasks(id)
                .stream()
                .map(taskMapper::toDto)
                .toList();

    }

    @GetMapping(path = "/{task_id}")
    public Optional<TaskDto> GetTaskById(@PathVariable("task_id") UUID TaskId, @PathVariable("taskList_id") UUID TaskListId) {
        return taskService.GetTaskById(TaskId, TaskListId).map(taskMapper::toDto);
    }

    @PostMapping(path = "/create")
    public TaskDto createTask(@PathVariable("taskList_id") UUID id, @RequestBody TaskDto taskDto) {
        Tasks Createdtask = taskService.CreateTask(id, taskMapper.fromDto(taskDto));
        return taskMapper.toDto(Createdtask);
    }

    @PutMapping(path = "/{task_id}")
    public TaskDto updateTask(@PathVariable("taskList_id") UUID TaskListId, @PathVariable("task_id") UUID taskId, @RequestBody TaskDto taskDto) {
        Tasks updatedTask = taskService.UpdateTask(TaskListId, taskId, taskMapper.fromDto(taskDto));
        return taskMapper.toDto(updatedTask);
    }

    @DeleteMapping(path = "/{task_id}")
    public void deleteTask(@PathVariable("taskList_id") UUID TaskListId, @PathVariable("task_id") UUID TaskId) {
        taskService.DeleteTask(TaskId, TaskListId);
    }
}
