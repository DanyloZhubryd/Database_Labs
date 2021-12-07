package ua.lviv.iot.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Kindergarden;
import ua.lviv.iot.repository.KindergardenRepository;
import ua.lviv.iot.service.AbstractService;

@AllArgsConstructor
@Service
public class KindergardenService extends AbstractService<Kindergarden> {
    private KindergardenRepository kindergardenRepository;

    @Override
    public JpaRepository<Kindergarden, Integer> getRepository(){
        return kindergardenRepository;
    }
}
