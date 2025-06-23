package org.example.tt_backened.Controller;

import org.example.tt_backened.DTO.TaskListDto;
import org.example.tt_backened.Entities.TaskLists;
import org.example.tt_backened.Mappers.TaskListMapper;
import org.example.tt_backened.Services.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/task_lists")
public class TaskListController {

    @Autowired
    private TaskListService taskListService;

    @Autowired
    private TaskListMapper taskListMapper;

    @GetMapping
    public List<TaskListDto> listTaskLists() {
        return taskListService.listTaskLists()
                .stream()
                .map(taskListMapper::toDto)
                .toList();
    }

    @PostMapping("/create")
    public TaskListDto createTaskList(@RequestBody TaskListDto taskListDto) {
        TaskLists newTaskList = taskListService.createTaskList(taskListMapper.fromDto(taskListDto));
        return taskListMapper.toDto(newTaskList);
    }

    @GetMapping(path = "/{taskList_id}")
    public Optional<TaskListDto> getTaskListById(@PathVariable("taskList_id") UUID id) {
        return taskListService.getTaskList(id).map(taskListMapper::toDto);

    }

    @PutMapping(path = "/{taskList_id}")
    public TaskListDto updateTaskList(@PathVariable("taskList_id") UUID id, @RequestBody TaskListDto taskListDto) {
        TaskLists updateTaskList = taskListService.updateTaskList(id, taskListMapper.fromDto(taskListDto));
        return taskListMapper.toDto(updateTaskList);
    }

    @DeleteMapping(path = "/{taskList_id}")
    public void deleteTaskList(@PathVariable("taskList_id") UUID id) {
        taskListService.deleteTaskList(id);
    }

}
