package ua.lviv.iot.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Worker;
import ua.lviv.iot.repository.WorkerRepository;
import ua.lviv.iot.service.AbstractService;

@AllArgsConstructor
@Service
public class WorkerService extends AbstractService<Worker> {
    private WorkerRepository workerRepository;

    @Override
    public JpaRepository<Worker, Integer> getRepository(){
        return workerRepository;
    }
}
