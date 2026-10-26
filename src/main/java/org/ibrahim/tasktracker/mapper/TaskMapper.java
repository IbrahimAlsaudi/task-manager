package org.ibrahim.tasktracker.mapper;

import org.ibrahim.tasktracker.domain.CreateTaskRequest;
import org.ibrahim.tasktracker.domain.UpdateTaskRequest;
import org.ibrahim.tasktracker.domain.dto.CreateTaskRequestDto;
import org.ibrahim.tasktracker.domain.dto.TaskDto;
import org.ibrahim.tasktracker.domain.dto.UpdateTaskRequestDto;
import org.ibrahim.tasktracker.domain.entity.Task;

public interface TaskMapper {
    CreateTaskRequest fromDto(CreateTaskRequestDto dto);

    UpdateTaskRequest fromDto(UpdateTaskRequestDto dto);

    TaskDto toDto(Task task);
}
