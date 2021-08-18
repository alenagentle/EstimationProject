package ru.irlix.evaluation.dto.request;

import lombok.*;
import ru.irlix.evaluation.dao.entity.Phase;

@Data
public class TaskRequest {
    private Long id;
    private String name;
    private Phase phase;
}
