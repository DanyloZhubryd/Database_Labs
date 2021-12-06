package ua.lviv.iot.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Position;
import ua.lviv.iot.repository.PositionRepository;
import ua.lviv.iot.service.AbstractService;

@AllArgsConstructor
@Service
public class PositionService extends AbstractService<Position> {
    private PositionRepository positionRepository;

    @Override
    public JpaRepository<Position, Integer> getRepository(){
        return positionRepository;
    }
}
