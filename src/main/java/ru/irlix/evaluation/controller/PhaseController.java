package ru.irlix.evaluation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.irlix.evaluation.dto.request.PhaseRequest;
import ru.irlix.evaluation.dto.response.PhaseResponse;
import ru.irlix.evaluation.service.phase.PhaseService;
import ru.irlix.evaluation.utils.Constants;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Constants.BASE_URL + "phases")
@RequiredArgsConstructor
public class PhaseController {

    private final PhaseService phaseService;

    @PostMapping
    public ResponseEntity<Long> createPhase(@Valid @RequestBody PhaseRequest phaseRequest){
        Long id = phaseService.createPhase(phaseRequest);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<PhaseResponse> updatePhase(@PathVariable("id") Long id,
                                                     @RequestBody PhaseRequest phaseRequest){
        PhaseResponse phaseResponse = phaseService.updatePhase(id, phaseRequest);
        return  new ResponseEntity<>(phaseResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhaseResponse> getPhaseById(@PathVariable("id") Long id){
        PhaseResponse phaseResponse = phaseService.getPhaseResponseById(id);
        return new ResponseEntity<>(phaseResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deletePhase(@PathVariable("id") Long id){
        phaseService.deletePhaseById(id);
    }

    @GetMapping("/estimation/{id}")
    public ResponseEntity<List<PhaseResponse>> getPhasesByEstimationId(@PathVariable("id") Long id){
        List<PhaseResponse> phaseListByEstimationId = phaseService.getPhaseListByEstimationId(id);
        return new ResponseEntity<>(phaseListByEstimationId, HttpStatus.OK);
    }
}
