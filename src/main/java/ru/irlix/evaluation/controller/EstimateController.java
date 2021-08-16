package ru.irlix.evaluation.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import ru.irlix.evaluation.dto.EstimateDTO;
import ru.irlix.evaluation.service.EstimateService;
import ru.irlix.evaluation.utils.Utils;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EstimateController {

    private final EstimateService estimateService;

    @RequestMapping(value = Utils.BASE_URL + "estimation", method = RequestMethod.POST)
    public void saveEstimate(@RequestBody EstimateDTO estimateDTO) {
        estimateService.saveEstimate(estimateDTO);
    }

}