package ua.lviv.iot.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Lesson;
import ua.lviv.iot.repository.LessonRepository;
import ua.lviv.iot.service.AbstractService;

@AllArgsConstructor
@Service
public class LessonService extends AbstractService<Lesson> {
    private final LessonRepository lessonRepository;

    @Override
    public JpaRepository<Lesson, Integer> getRepository(){
        return lessonRepository;
    }
}
