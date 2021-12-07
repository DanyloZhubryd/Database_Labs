package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.Lesson;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Integer> {
}
