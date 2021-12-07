package ua.lviv.iot.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Address;
import ua.lviv.iot.repository.AddressRepository;
import ua.lviv.iot.service.AbstractService;

@AllArgsConstructor
@Service
public class AddressService extends AbstractService<Address> {
    private final AddressRepository addressRepository;

    @Override
    public JpaRepository<Address, Integer> getRepository(){
        return addressRepository;
    }
}
