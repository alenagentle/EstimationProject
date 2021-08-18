package ru.irlix.evaluation.component;


import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import ru.irlix.evaluation.dto.request.PhaseRequest;
import ru.irlix.evaluation.dao.entity.Estimation;
import ru.irlix.evaluation.service.estimation.EstimationService;

@Component
@RequiredArgsConstructor
public class EstimationComponent {

    private final EstimationService estimationService;

    @Named("idToEstimation")
    public Estimation idToEstimation(PhaseRequest phaseRequest) {
        return estimationService.getEstimationById(phaseRequest.getEstimationId());
    }


}
