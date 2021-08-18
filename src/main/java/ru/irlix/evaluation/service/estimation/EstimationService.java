package ru.irlix.evaluation.service.estimation;

import ru.irlix.evaluation.dto.request.EstimationRequest;
import ru.irlix.evaluation.dto.response.EstimationResponse;
import ru.irlix.evaluation.dao.entity.Estimation;

import java.util.List;

public interface EstimationService {
    EstimationResponse createEstimation(EstimationRequest estimationRequest);
    EstimationResponse getEstimationResponseById(Long id);
    List<EstimationResponse> getAll();
    void deleteEstimationById(Long id);
    EstimationResponse updateEstimationById(Long id, EstimationRequest estimationRequest);
    Estimation getEstimationById(Long id);
}
