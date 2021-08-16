package ru.irlix.evaluation.mapper;

import org.mapstruct.Mapper;
<<<<<<< HEAD
import org.mapstruct.factory.Mappers;
import ru.irlix.evaluation.dao.entity.Estimate;
import ru.irlix.evaluation.dao.entity.Phase;
import ru.irlix.evaluation.dao.entity.Role;
import ru.irlix.evaluation.dto.EstimateDTO;
import ru.irlix.evaluation.dto.PhaseDTO;
import ru.irlix.evaluation.dto.RoleDTO;
=======
import ru.irlix.evaluation.dao.entity.Estimate;
import ru.irlix.evaluation.dao.entity.Phase;
import ru.irlix.evaluation.dto.EstimateDTO;
import ru.irlix.evaluation.dto.PhaseDTO;
>>>>>>> 64bf13eca89b85e9871141df1a8e3551c2ccbb8d

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstimateMapper {

<<<<<<< HEAD
    EstimateMapper ESTIMATE_MAPPER = Mappers.getMapper(EstimateMapper.class);

=======
>>>>>>> 64bf13eca89b85e9871141df1a8e3551c2ccbb8d
    Estimate estimateDtoToEstimate(EstimateDTO estimateDto);
    EstimateDTO estimateToEstimateDto(Estimate estimate);

    PhaseDTO phaseToPhaseDto(Phase phase);
    Phase phaseDtoToPhase(PhaseDTO phaseDTO);

    List<PhaseDTO> phasesToPhasesDto (List<Phase> phases);
    List<Phase> phasesDtoToPhases (List<PhaseDTO> phasesDTO);

<<<<<<< HEAD
    RoleDTO roleToRoleDto(Role role);
    Role roleDtoToRole(RoleDTO roleDTO);

=======
>>>>>>> 64bf13eca89b85e9871141df1a8e3551c2ccbb8d
}
