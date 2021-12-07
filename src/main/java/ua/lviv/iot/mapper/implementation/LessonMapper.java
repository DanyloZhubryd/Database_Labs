package ua.lviv.iot.mapper.implementation;

import org.springframework.stereotype.Component;
import ua.lviv.iot.DTO.LessonDTO;
import ua.lviv.iot.domain.Lesson;
import ua.lviv.iot.mapper.AbstractMapper;

@Component
public class LessonMapper implements AbstractMapper<Lesson, LessonDTO> {
    @Override
    public LessonDTO map(Lesson lesson){
        return LessonDTO.builder()
                .id(lesson.getId())
                .name(lesson.getName())
                .classroom((lesson.getClassroom() == null) ? null : lesson.getClassroom())
                .lessonDay(lesson.getLessonDay())
                .lessonTime(lesson.getLessonTime().toString())
                .build();
    }
}
