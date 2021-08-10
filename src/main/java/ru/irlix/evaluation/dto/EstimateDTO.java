package ru.irlix.evaluation.dto;

import lombok.Data;

@Data
public class EstimateDTO {
    private Long id;
    private String name;
    private String createDate;
    private String description;
    private Integer risk;
    private Integer status;
    private String client;
    private String creator;
}
