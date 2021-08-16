package ru.irlix.evaluation.service;

<<<<<<< HEAD
import ru.irlix.evaluation.dao.entity.Phase;
import ru.irlix.evaluation.dto.EstimateDTO;

import java.util.List;

public interface EstimateService {
    void saveEstimate(EstimateDTO estimateDTO);
    void savePhases(List<Phase> phases);
    void savePhase(Phase phase);
=======
import ru.irlix.evaluation.dto.EstimateDTO;

public interface EstimateService {
    void saveEstimate(EstimateDTO estimateDTO);
>>>>>>> 64bf13eca89b85e9871141df1a8e3551c2ccbb8d
}
