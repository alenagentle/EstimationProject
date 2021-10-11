package ru.irlix.evaluation.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.irlix.evaluation.dto.request.TaskTypeRequest;
import ru.irlix.evaluation.dto.response.TaskTypeResponse;
import ru.irlix.evaluation.service.TaskTypeService;
import ru.irlix.evaluation.utils.constant.UrlConstants;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping(UrlConstants.BASE_URL + "/types")
@RequiredArgsConstructor
@CrossOrigin
@Validated
@Log4j2
public class TaskTypeController {

    private final TaskTypeService taskTypeService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public TaskTypeResponse createTaskType(@RequestBody @Valid TaskTypeRequest request) {
        log.info(UrlConstants.RECEIVED_ENTITY);
        return taskTypeService.createTaskType(request);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public TaskTypeResponse updateTaskType(@PathVariable @Positive(message = "{id.positive}") Long id,
                                           @RequestBody @Valid TaskTypeRequest request) {
        log.info(UrlConstants.RECEIVED_ENTITY_ID + id);
        return taskTypeService.updateTaskType(id, request);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteTaskType(@PathVariable @Positive(message = "{id.positive}") Long id) {
        log.info(UrlConstants.RECEIVED_ID + id);
        taskTypeService.deleteTaskType(id);
    }

    @GetMapping
    public List<TaskTypeResponse> findAllTaskTypes() {
        log.info(UrlConstants.RECEIVED_NO_ARGS);
        return taskTypeService.findAllTaskTypes();
    }

    @GetMapping("/{id}")
    public TaskTypeResponse findTaskTypeById(@PathVariable @Positive(message = "{id.positive}") Long id) {
        log.info(UrlConstants.RECEIVED_ID + id);
        return taskTypeService.findTaskTypeResponseById(id);
    }
}
