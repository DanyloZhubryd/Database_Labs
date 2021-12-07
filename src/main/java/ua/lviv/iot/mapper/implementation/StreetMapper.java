package ua.lviv.iot.mapper.implementation;

import org.springframework.stereotype.Component;
import ua.lviv.iot.DTO.StreetDTO;
import ua.lviv.iot.domain.Street;
import ua.lviv.iot.mapper.AbstractMapper;

@Component
public class StreetMapper implements AbstractMapper<Street, StreetDTO> {
    @Override
    public StreetDTO map(Street street){
        return StreetDTO.builder()
                .id(street.getId())
                .name(street.getName())
                .build();
    }
}
