package ua.lviv.iot.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.ChildGroup;
import ua.lviv.iot.repository.ChildGroupRepository;
import ua.lviv.iot.service.AbstractService;

@AllArgsConstructor
@Service
public class ChildGroupService extends AbstractService<ChildGroup> {
    private ChildGroupRepository childGroupRepository;

    @Override
    public JpaRepository<ChildGroup, Integer> getRepository(){
        return childGroupRepository;
    }
}
