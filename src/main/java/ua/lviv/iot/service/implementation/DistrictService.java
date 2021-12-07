package ua.lviv.iot.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.District;
import ua.lviv.iot.repository.DistrictRepository;
import ua.lviv.iot.service.AbstractService;

@AllArgsConstructor
@Service
public class DistrictService extends AbstractService<District> {
    private final DistrictRepository districtRepository;

    @Override
    public JpaRepository<District, Integer> getRepository(){
        return districtRepository;
    }
}
