package ru.irlix.evaluation.service.role;

import ru.irlix.evaluation.dao.entity.Role;

public interface RoleService {
    Role findRoleByDisplayValue(String displayValue);
}
