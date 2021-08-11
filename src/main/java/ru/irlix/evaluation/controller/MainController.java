package ru.irlix.evaluation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.irlix.evaluation.dto.EstimateDTO;
import ru.irlix.evaluation.service.EstimateServiceImpl;

@RestController
public class MainController {

    private EstimateServiceImpl estimateService;

    @Autowired
    public void setEstimateService(EstimateServiceImpl estimateService) {
        this.estimateService = estimateService;
    }

    @PostMapping("/save")
    public String saveEstimate(EstimateDTO estimateDTO){

        return "saving page";
    }

}
