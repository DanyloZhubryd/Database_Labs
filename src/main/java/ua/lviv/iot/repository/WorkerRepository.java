package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Integer> {
}
