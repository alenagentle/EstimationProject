package ru.irlix.evaluation.dto.response;

import lombok.*;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstimationResponse {

    private Long id;

    private String name;

    private Instant createDate;

    private String description;

    private Integer risk;

    private String client;

    private String creator;

    private Long status;

    private List<PhaseResponse> phases;
}
