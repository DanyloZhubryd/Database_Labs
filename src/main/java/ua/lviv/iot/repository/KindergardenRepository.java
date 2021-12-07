package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.Kindergarden;

@Repository
public interface KindergardenRepository extends JpaRepository<Kindergarden, Integer> {
}
