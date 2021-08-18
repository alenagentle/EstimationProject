package ru.irlix.evaluation.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhaseResponse {
    private Long id;
    private String name;
    private Integer estimationId;
    private Integer sortOrder;
    private Integer managementReserve;
    private Integer bagsReserve;
    private Integer qaReserve;
    private Integer riskReserve;
    private String estimationRole;
    private Boolean done;
    private Boolean managementReserveOn;
    private Boolean qaReserveOn;
    private Boolean bagsReserveOn;
}
