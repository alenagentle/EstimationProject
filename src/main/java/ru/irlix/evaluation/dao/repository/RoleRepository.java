package ru.irlix.evaluation.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.irlix.evaluation.dao.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByDisplayValue(String displayValue);
}
