package ru.irlix.evaluation.dao.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.irlix.evaluation.component.EstimationComponent;
import ru.irlix.evaluation.dao.entity.Task;
import ru.irlix.evaluation.dto.request.PhaseRequest;
import ru.irlix.evaluation.dto.request.TaskRequest;
import ru.irlix.evaluation.dto.response.PhaseResponse;
import ru.irlix.evaluation.dao.entity.Phase;

import java.util.List;

@Mapper(componentModel = "spring", uses= EstimationComponent.class)
public interface PhaseMapper {

    @Mapping(source = "phaseRequest", target = "estimation", qualifiedByName = "idToEstimation")
    Phase phaseRequestToPhase(PhaseRequest phaseRequest);
    PhaseResponse phaseToPhaseResponse(Phase phase);

    List<Task> taskRequestListToTaskList(List<TaskRequest> taskRequests);
    List<TaskRequest> taskListToTaskRequestList(List<Task> taskList);

    List<Phase> phaseResponseListToPhaseList(List<PhaseResponse> phaseResponseList);
    List<PhaseResponse> phaseListToPhaseResponseList(List<Phase> phaseList);
}
