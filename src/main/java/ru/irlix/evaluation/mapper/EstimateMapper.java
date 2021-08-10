package ru.irlix.evaluation.mapper;

import org.mapstruct.Mapper;
import ru.irlix.evaluation.dao.entity.Estimate;
import ru.irlix.evaluation.dto.EstimateDTO;

@Mapper
public interface EstimateMapper {
    Estimate dtoToEntity(EstimateDTO estimateDto);
    EstimateDTO entityToDto(Estimate estimate);
}
