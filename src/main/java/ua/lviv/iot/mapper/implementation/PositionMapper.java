package ua.lviv.iot.mapper.implementation;

import org.springframework.stereotype.Component;
import ua.lviv.iot.DTO.PositionDTO;
import ua.lviv.iot.domain.Position;
import ua.lviv.iot.mapper.AbstractMapper;

@Component
public class PositionMapper implements AbstractMapper<Position, PositionDTO> {
    @Override
    public PositionDTO map(Position position){
        return PositionDTO.builder()
                .id(position.getId())
                .name(position.getName())
                .salary(position.getSalary())
                .bonus((position.getBonus() == null) ? null : position.getBonus())
                .build();
    }
}
