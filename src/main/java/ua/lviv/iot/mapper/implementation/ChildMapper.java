package ua.lviv.iot.mapper.implementation;

import org.springframework.stereotype.Component;
import ua.lviv.iot.DTO.ChildDTO;
import ua.lviv.iot.domain.Child;
import ua.lviv.iot.mapper.AbstractMapper;

@Component
public class ChildMapper implements AbstractMapper<Child, ChildDTO> {
    @Override
    public ChildDTO map(Child child){
        return ChildDTO.builder()
                .id(child.getId())
                .birthCertificate(child.getBirthCertificate())
                .name(child.getName())
                .surname(child.getSurname())
                .birthDate(child.getBirthDate().toString())
                .childGroupId(child.getChildGroup().getId())
                .build();
    }
}
