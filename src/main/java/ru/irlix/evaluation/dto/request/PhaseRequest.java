package ru.irlix.evaluation.dto.request;

import lombok.*;

@Data
public class PhaseRequest {
    private String name;
    private Long estimationId;
    private Integer sortOrder;
    private Integer managementReserve;
    private Integer qaReserve;
    private Integer bagsReserve;
    private Integer riskReserve;
    private String estimationRole;
    private Boolean done;
    private Boolean managementReserveOn;
    private Boolean qaReserveOn;
    private Boolean bagsReserveOn;
}
