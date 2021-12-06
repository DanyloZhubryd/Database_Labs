package ua.lviv.iot.mapper.implementation;

import org.springframework.stereotype.Component;
import ua.lviv.iot.DTO.DistrictDTO;
import ua.lviv.iot.domain.District;
import ua.lviv.iot.mapper.AbstractMapper;

@Component
public class DistrictMapper implements AbstractMapper<District, DistrictDTO> {
    @Override
    public DistrictDTO map(District district){
        return DistrictDTO.builder()
                .id(district.getId())
                .name(district.getName())
                .build();
    }
}
