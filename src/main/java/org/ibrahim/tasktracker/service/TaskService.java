package org.ibrahim.tasktracker.service;

import org.ibrahim.tasktracker.domain.CreateTaskRequest;
import org.ibrahim.tasktracker.domain.UpdateTaskRequest;
import org.ibrahim.tasktracker.domain.entity.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    Task createTask(CreateTaskRequest request);
    List<Task> listTasks();
    Task updateTask(UUID taskId, UpdateTaskRequest request);
    void deleteTask(UUID taskId);
}
