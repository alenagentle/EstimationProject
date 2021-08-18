package ru.irlix.evaluation.service.phase;

import ru.irlix.evaluation.dto.request.PhaseRequest;
import ru.irlix.evaluation.dto.response.PhaseResponse;

import java.util.List;

public interface PhaseService {
    Long createPhase(PhaseRequest phaseRequest);
    PhaseResponse updatePhase(Long id, PhaseRequest phaseRequest);
    PhaseResponse getPhaseResponseById(Long id);
    void deletePhaseById(Long id);
    List<PhaseResponse> getPhaseListByEstimationId(Long id);
}
