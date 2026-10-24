package org.ibrahim.tasktracker.domain.dto;

import org.ibrahim.tasktracker.domain.entity.TaskPriority;
import org.ibrahim.tasktracker.domain.entity.TaskStatus;

import java.time.LocalDate;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDate dueDate,
        TaskPriority priority,
        TaskStatus status

) {
}
