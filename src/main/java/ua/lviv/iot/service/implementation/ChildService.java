package ua.lviv.iot.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Child;
import ua.lviv.iot.repository.ChildRepository;
import ua.lviv.iot.service.AbstractService;

@AllArgsConstructor
@Service
public class ChildService extends AbstractService<Child> {
    private final ChildRepository childRepository;

    @Override
    public JpaRepository<Child, Integer> getRepository(){
        return childRepository;
    }
}
