package ua.lviv.iot.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Street;
import ua.lviv.iot.repository.StreetRepository;
import ua.lviv.iot.service.AbstractService;

@AllArgsConstructor
@Service
public class StreetService extends AbstractService<Street> {
    private StreetRepository streetRepository;

    @Override
    public JpaRepository<Street, Integer> getRepository(){
        return streetRepository;
    }
}
