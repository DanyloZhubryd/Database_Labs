package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.Child;

@Repository
public interface ChildRepository extends JpaRepository<Child, Integer> {
}
