package ua.lviv.iot.mapper.implementation;

import org.springframework.stereotype.Component;
import ua.lviv.iot.DTO.ChildGroupDTO;
import ua.lviv.iot.domain.ChildGroup;
import ua.lviv.iot.mapper.AbstractMapper;

@Component
public class ChildGroupMapper implements AbstractMapper<ChildGroup, ChildGroupDTO>{
    @Override
    public ChildGroupDTO map(ChildGroup childGroup){
        return ChildGroupDTO.builder()
                .id(childGroup.getId())
                .name(childGroup.getName())
                .bedroomNumber(childGroup.getBedroomNumber())
                .kindergardenId(childGroup.getKindergarden().getId())
                .workerId(childGroup.getWorker().getId())
                .build();
    }
}
