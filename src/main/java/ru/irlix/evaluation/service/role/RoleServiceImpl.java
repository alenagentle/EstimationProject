package ru.irlix.evaluation.service.role;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.irlix.evaluation.dao.entity.Role;
import ru.irlix.evaluation.dao.repository.RoleRepository;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role findRoleByDisplayValue(String displayValue) {
        return roleRepository.findByDisplayValue(displayValue)
                .orElse(null);
    }
}
