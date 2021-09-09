package ru.irlix.evaluation.service;

import ru.irlix.evaluation.dto.request.TaskRequest;
import ru.irlix.evaluation.dto.request.TaskUpdateRequest;
import ru.irlix.evaluation.dto.response.TaskResponse;

import java.util.List;

public interface TaskService {
    TaskResponse createTask(TaskRequest request);

    List<TaskResponse> createTasks(List<TaskRequest> requests);

    TaskResponse updateTask(Long id, TaskRequest taskRequest);

    List<TaskResponse> updateTasks(List<TaskUpdateRequest> taskRequest);

    TaskResponse findTaskResponseById(Long id);

    List<TaskResponse> findTasks(Long phaseId);

    void deleteTask(Long id);
}
