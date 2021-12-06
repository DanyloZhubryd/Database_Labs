package ua.lviv.iot.mapper.implementation;

import org.springframework.stereotype.Component;
import ua.lviv.iot.DTO.AddressDTO;
import ua.lviv.iot.domain.Address;
import ua.lviv.iot.mapper.AbstractMapper;

@Component
public class AddressMapper implements AbstractMapper<Address, AddressDTO> {
    @Override
    public AddressDTO map(Address address){
        return AddressDTO.builder()
                .id(address.getId())
                .number(address.getNumber())
                .street_id(address.getStreet().getId())
                .district_id(address.getDistrict().getId())
                .build();
    }
}
