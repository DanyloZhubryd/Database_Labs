package ua.lviv.iot.mapper.implementation;

import org.springframework.stereotype.Component;
import ua.lviv.iot.DTO.KindergardenDTO;
import ua.lviv.iot.domain.Kindergarden;
import ua.lviv.iot.mapper.AbstractMapper;

@Component
public class KindergardenMapper implements AbstractMapper<Kindergarden, KindergardenDTO> {
    @Override
    public KindergardenDTO map(Kindergarden kindergarden){
        return KindergardenDTO.builder()
                .id(kindergarden.getId())
                .flatsCount(kindergarden.getFlatsCount())
                .workersCount((kindergarden.getWorkersCount() == null) ? null : (kindergarden.getWorkersCount()))
                .groupCount((kindergarden.getGroupCount() == null) ? null : kindergarden.getGroupCount())
                .addressId(kindergarden.getAddress().getId())
                .build();
    }
}
