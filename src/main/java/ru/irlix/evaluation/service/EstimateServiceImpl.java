package ru.irlix.evaluation.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.irlix.evaluation.dao.entity.Estimate;
import ru.irlix.evaluation.dao.repository.EstimateRepository;
import ru.irlix.evaluation.dto.EstimateDTO;
import ru.irlix.evaluation.mapper.EstimateMapper;

@Service
@AllArgsConstructor
public class EstimateServiceImpl implements EstimateService{

    private EstimateRepository estimateRepository;
    private EstimateMapper mapper;

    @Override
    public boolean saveEstimate(EstimateDTO estimateDTO) {

        Estimate estimate = mapper.estimateDtoToEstimate(estimateDTO);
//        System.out.println("exists: " + estimateRepository.existsEstimateById(estimate.getId()));
//        if(estimateRepository.existsEstimateById(estimate.getId()))
//        {
//            return false;
//        }
//        else
            estimateRepository.save(estimate);
        return true;
    }
}
