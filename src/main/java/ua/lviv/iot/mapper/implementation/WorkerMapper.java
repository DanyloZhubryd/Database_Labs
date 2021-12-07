package ua.lviv.iot.mapper.implementation;

import org.springframework.stereotype.Component;
import ua.lviv.iot.DTO.WorkerDTO;
import ua.lviv.iot.domain.Worker;
import ua.lviv.iot.mapper.AbstractMapper;

@Component
public class WorkerMapper implements AbstractMapper<Worker, WorkerDTO> {
    @Override
    public WorkerDTO map(Worker worker){
        return WorkerDTO.builder()
                .id(worker.getId())
                .name(worker.getName())
                .surname(worker.getSurname())
                .hireDate(worker.getHireDate().toString())
                .fireDate((worker.getFireDate() == null) ? null : worker.getFireDate().toString())
                .kindergardenId(worker.getKindergarden().getId())
                .positionId(worker.getPosition().getId())
                .build();
    }
}
