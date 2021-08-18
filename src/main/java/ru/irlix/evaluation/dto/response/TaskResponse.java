package ru.irlix.evaluation.dto.response;

import lombok.Data;

@Data
public class TaskResponse {
    private Long id;
    private String name;
    private Integer repeatCount;
    private Integer bagsReserve;
    private Integer qaReserve;
    private Integer managementReserve;
    private Integer riskReserve;
    private String comment;
    private Integer hoursMin;
    private Integer hoursMax;
    private PhaseResponse phase;
    private RoleResponse role;
    private Integer parent;
}
