package ru.irlix.evaluation.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.irlix.evaluation.dao.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
