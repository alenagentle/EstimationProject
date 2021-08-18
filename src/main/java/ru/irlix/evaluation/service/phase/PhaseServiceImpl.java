package ru.irlix.evaluation.service.phase;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.irlix.evaluation.dto.request.PhaseRequest;
import ru.irlix.evaluation.dto.response.PhaseResponse;
import ru.irlix.evaluation.dao.entity.Estimation;
import ru.irlix.evaluation.dao.entity.Phase;
import ru.irlix.evaluation.dao.mapper.PhaseMapper;
import ru.irlix.evaluation.dao.repository.EstimationRepository;
import ru.irlix.evaluation.dao.repository.PhaseRepository;
import ru.irlix.evaluation.exception.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PhaseServiceImpl implements PhaseService {

    private final PhaseRepository phaseRepository;
    private final EstimationRepository estimationRepository;
    private final PhaseMapper mapper;

    @Override
    public Long createPhase(PhaseRequest phaseRequest) {
        Phase phase = mapper.phaseRequestToPhase(phaseRequest);
        Phase savedPhase = phaseRepository.save(phase);
        return savedPhase.getId();
    }

    @Override
    public PhaseResponse updatePhase(Long id, PhaseRequest phaseRequest) {
        Phase phase = phaseRepository.findPhaseById(id).orElseThrow(() -> {
            return new NotFoundException("Phase not found with id=" + id);
        });
        Phase updatedPhase = checkAndUpdateFields(phase, phaseRequest);
        Phase savedPhase = phaseRepository.save(updatedPhase);
        return mapper.phaseToPhaseResponse(savedPhase);
    }

    private Phase checkAndUpdateFields(Phase phase, PhaseRequest phaseRequest) {
        if (phaseRequest.getName() != null) {
            phase.setName(phaseRequest.getName());
        }
        if (phaseRequest.getEstimationId() != null) {
            Estimation estimation = estimationRepository.findEstimationById(phaseRequest.getEstimationId());
            phase.setEstimation(estimation);
        }
        if (phaseRequest.getSortOrder() != null) {
            phase.setSortOrder(phaseRequest.getSortOrder());
        }
        if (phaseRequest.getManagementReserve() != null) {
            phase.setManagementReserve(phaseRequest.getManagementReserve());
        }
        if (phaseRequest.getQaReserve() != null) {
            phase.setQaReserve(phaseRequest.getQaReserve());
        }
        if (phaseRequest.getBagsReserve() != null) {
            phase.setBagsReserve(phaseRequest.getBagsReserve());
        }
        if (phaseRequest.getRiskReserve() != null) {
            phase.setRiskReserve(phaseRequest.getRiskReserve());
        }

        if (phaseRequest.getDone() != null) {
            phase.setDone(phaseRequest.getDone());
        }
        if (phaseRequest.getManagementReserveOn() != null) {
            phase.setManagementReserveOn(phaseRequest.getManagementReserveOn());
        }
        if (phaseRequest.getQaReserveOn() != null) {
            phase.setQaReserveOn(phaseRequest.getQaReserveOn());
        }
        if (phaseRequest.getBagsReserveOn() != null) {
            phase.setBagsReserveOn(phaseRequest.getBagsReserveOn());
        }
        return phase;
    }

    @Override
    public PhaseResponse getPhaseResponseById(Long id) {
        Phase phase = phaseRepository.findPhaseById(id).orElseThrow(() -> {
            return new NotFoundException("Phase not found with id=" + id);
        });
        return mapper.phaseToPhaseResponse(phase);
    }

    @Override
    public void deletePhaseById(Long id) {
        if (phaseRepository.existsById(id)) {
            phaseRepository.deleteById(id);
        }
    }

    @Override
    @Transactional
    public List<PhaseResponse> getPhaseListByEstimationId(Long id) {
        List<Phase> phases = estimationRepository.findEstimationById(id).getPhases();
        return phases.stream()
                .map(mapper::phaseToPhaseResponse)
                .collect(Collectors.toList());
    }
}
