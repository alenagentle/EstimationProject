package ru.irlix.evaluation.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StatusResponse {
    private Long id;
    private String value;
    private String displayValue;
}
