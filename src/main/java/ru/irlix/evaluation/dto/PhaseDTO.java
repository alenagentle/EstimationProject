package ru.irlix.evaluation.dto;

import lombok.Data;
<<<<<<< HEAD
import ru.irlix.evaluation.dao.entity.Role;
=======
>>>>>>> 64bf13eca89b85e9871141df1a8e3551c2ccbb8d

@Data
public class PhaseDTO {
    private Long id;
    private String name;
<<<<<<< HEAD
    private EstimateDTO estimate;
=======
    private Integer estimate;
>>>>>>> 64bf13eca89b85e9871141df1a8e3551c2ccbb8d
    private Integer sortOrder;
    private Integer managementReserve;
    private Integer bagsReserve;
    private Integer qaReserve;
    private Integer riskReserve;
<<<<<<< HEAD
    private RoleDTO role;
=======
    private String role;
>>>>>>> 64bf13eca89b85e9871141df1a8e3551c2ccbb8d
}
