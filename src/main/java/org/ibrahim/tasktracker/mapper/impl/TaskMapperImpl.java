package org.ibrahim.tasktracker.mapper.impl;

import org.ibrahim.tasktracker.domain.CreateTaskRequest;
import org.ibrahim.tasktracker.domain.UpdateTaskRequest;
import org.ibrahim.tasktracker.domain.dto.CreateTaskRequestDto;
import org.ibrahim.tasktracker.domain.dto.TaskDto;
import org.ibrahim.tasktracker.domain.dto.UpdateTaskRequestDto;
import org.ibrahim.tasktracker.domain.entity.Task;
import org.ibrahim.tasktracker.mapper.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {
    @Override
    public CreateTaskRequest fromDto(CreateTaskRequestDto dto) {
        return new CreateTaskRequest(
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.priority()
        );
    }

    @Override
    public TaskDto toDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getPriority(),
                task.getStatus()
        );
    }

    @Override
    public UpdateTaskRequest fromDto(UpdateTaskRequestDto dto) {
        return new UpdateTaskRequest(
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.status(),
                dto.priority()
        );
    }
}
