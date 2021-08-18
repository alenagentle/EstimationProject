package ru.irlix.evaluation.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.irlix.evaluation.dao.entity.Estimation;

@Repository
public interface EstimationRepository extends JpaRepository<Estimation, Long> {
    Estimation findEstimationById(Long id);
    boolean existsById(Long id);
}
