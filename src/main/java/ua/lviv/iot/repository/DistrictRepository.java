package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.District;

@Repository
public interface DistrictRepository extends JpaRepository<District, Integer> {
}
