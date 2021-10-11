package ru.irlix.evaluation.dao.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import ru.irlix.evaluation.dao.entity.Estimation;
import ru.irlix.evaluation.dao.entity.Phase;
import ru.irlix.evaluation.dao.helper.EstimationHelper;
import ru.irlix.evaluation.dto.request.PhaseRequest;
import ru.irlix.evaluation.dto.response.PhaseResponse;

import java.util.List;

@Mapper(componentModel = "spring", uses = TaskMapper.class)
public abstract class PhaseMapper {

    @Autowired
    protected EstimationHelper estimationHelper;

    @Mapping(target = "estimation", ignore = true)
    public abstract Phase phaseRequestToPhase(PhaseRequest phaseRequest);

    public abstract List<Phase> phaseRequestToPhase(List<PhaseRequest> phaseRequest);

    @Mapping(target = "estimationId", ignore = true)
    public abstract PhaseResponse phaseToPhaseResponse(Phase phase);

    public abstract List<PhaseResponse> phaseToPhaseResponse(List<Phase> phase);

    @AfterMapping
    protected void map(@MappingTarget Phase phase, PhaseRequest request) {
        Estimation estimation = estimationHelper.findEstimationById(request.getEstimationId());
        phase.setEstimation(estimation);
    }

    @AfterMapping
    protected void map(@MappingTarget PhaseResponse response, Phase phase) {
        response.setEstimationId(phase.getEstimation().getId());
    }
}
