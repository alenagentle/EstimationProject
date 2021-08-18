package ru.irlix.evaluation.service.estimation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.irlix.evaluation.dto.request.EstimationRequest;
import ru.irlix.evaluation.dto.response.EstimationResponse;
import ru.irlix.evaluation.dao.entity.Estimation;
import ru.irlix.evaluation.dao.mapper.EstimationMapper;
import ru.irlix.evaluation.dao.repository.EstimationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EstimationServiceImpl implements EstimationService {

    private final EstimationRepository estimationRepository;
    private final EstimationMapper mapper;

    @Override
    public EstimationResponse createEstimation(EstimationRequest estimationRequest) {
        Estimation estimation = mapper.estimationRequestToEstimation(estimationRequest);
        Estimation savedEstimation = estimationRepository.save(estimation);
        return mapper.estimationToEstimationResponse(savedEstimation);
    }

    @Override
    public EstimationResponse getEstimationResponseById(Long id) {
        return mapper.estimationToEstimationResponse(estimationRepository.findEstimationById(id));
    }

    @Override
    public List<EstimationResponse> getAll() {
        return mapper.estimationListToEstimationsResponseList(estimationRepository.findAll());
    }

    @Override
    public void deleteEstimationById(Long id) {
        if (estimationRepository.existsById(id)) {
            estimationRepository.deleteById(id);
        }
    }

    @Override
    public EstimationResponse updateEstimationById(Long id, EstimationRequest estimationRequest) {
        Estimation estimationToUpdate = estimationRepository.findEstimationById(id);
        Estimation updatedEstimation = checkAndUpdateFields(estimationToUpdate, estimationRequest);
        Estimation savedEstimation = estimationRepository.save(updatedEstimation);
        return mapper.estimationToEstimationResponse(savedEstimation);
    }

    @Override
    public Estimation getEstimationById(Long id) {
        return estimationRepository.findEstimationById(id);
    }

    private Estimation checkAndUpdateFields(Estimation estimation, EstimationRequest request) {
        if (request.getName() != null) {
            estimation.setName(request.getName());
        }
        if (request.getClient() != null) {
            estimation.setClient(request.getClient());
        }
        if (request.getDescription() != null) {
            estimation.setDescription(request.getDescription());
        }
        return estimation;
    }
}
