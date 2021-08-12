package ru.irlix.evaluation.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.irlix.evaluation.dto.EstimateDTO;
import ru.irlix.evaluation.service.EstimateService;

@RestController
@AllArgsConstructor
public class MainController {

    private EstimateService estimateService;

    @PostMapping("/save")
    public String saveEstimate(EstimateDTO estimateDTO){
        estimateService.saveEstimate(estimateDTO);
        return "saving page";
    }

}
