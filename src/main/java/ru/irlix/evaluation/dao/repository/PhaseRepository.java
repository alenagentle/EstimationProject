package ru.irlix.evaluation.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.irlix.evaluation.dao.entity.Phase;

@Repository
public interface PhaseRepository extends JpaRepository<Phase, Long> {
    Phase findPhaseById(Long id);
    boolean existsById(Long id);
}
