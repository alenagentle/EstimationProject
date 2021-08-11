package ru.irlix.evaluation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.irlix.evaluation.dao.entity.Estimate;
import ru.irlix.evaluation.dao.repository.EstimateRepository;
import ru.irlix.evaluation.dto.EstimateDTO;

@Service
public class EstimateServiceImpl implements EstimateService{

    private EstimateRepository estimateRepository;

    @Autowired
    public void setEstimateRepository(EstimateRepository estimateRepository) {
        this.estimateRepository = estimateRepository;
    }

    @Override
    public boolean saveEstimate(EstimateDTO estimateDTO) {
        Estimate estimate = new Estimate();


        if(estimateRepository.existsEstimateById(estimate.getId()))
        {
            return false;
        }
        else
            estimateRepository.save(estimate);
        return true;
    }
}
