package org.ibrahim.tasktracker.service;

import org.ibrahim.tasktracker.domain.CreateTaskRequest;
import org.ibrahim.tasktracker.domain.entity.Task;

public interface TaskService {
    Task createTask(CreateTaskRequest request);
}
