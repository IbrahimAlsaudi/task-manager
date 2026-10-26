package org.ibrahim.tasktracker.controller;

import jakarta.validation.Valid;
import org.ibrahim.tasktracker.domain.CreateTaskRequest;
import org.ibrahim.tasktracker.domain.UpdateTaskRequest;
import org.ibrahim.tasktracker.domain.dto.CreateTaskRequestDto;
import org.ibrahim.tasktracker.domain.dto.TaskDto;
import org.ibrahim.tasktracker.domain.dto.UpdateTaskRequestDto;
import org.ibrahim.tasktracker.domain.entity.Task;
import org.ibrahim.tasktracker.mapper.TaskMapper;
import org.ibrahim.tasktracker.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/tasks")
public class TaskController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @PostMapping
    public ResponseEntity<TaskDto> createTask(
           @Valid @RequestBody CreateTaskRequestDto createTaskRequestDto
    ) {
        // Convert From Presentation -Controller- layer DTO to Service layer Entity
        CreateTaskRequest createTaskRequest = taskMapper.fromDto(createTaskRequestDto);
        Task task = taskService.createTask(createTaskRequest);
        // Convert To Dto to send it back as response to the user
        TaskDto createdTaskDto = taskMapper.toDto(task);

        return new ResponseEntity<>(createdTaskDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> getTasks() {
        List<Task> tasks = taskService.listTasks();
        List<TaskDto> taskDtos = tasks.stream().map(taskMapper::toDto).toList();
        return ResponseEntity.ok(taskDtos);
    }

    @PutMapping(path = "/{taskId}")
    public ResponseEntity<TaskDto> updateTask(
            @PathVariable UUID taskId,
            @Valid @RequestBody UpdateTaskRequestDto updateTaskRequestDto
    ) {

        UpdateTaskRequest updateTaskRequest = taskMapper.fromDto(updateTaskRequestDto);
        Task task = taskService.updateTask(taskId, updateTaskRequest);
        TaskDto dto = taskMapper.toDto(task);

        return ResponseEntity.ok(dto);
    }
}
