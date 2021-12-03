package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.ChildGroup;

@Repository
public interface ChildGroupRepository extends JpaRepository<ChildGroup, Integer> {
}
