package ru.irlix.evaluation.dto.response;

import lombok.Data;
import ru.irlix.evaluation.dao.entity.Phase;

@Data
public class TaskResponse {
    private Long id;
    private String name;
    private Phase phase;
}
