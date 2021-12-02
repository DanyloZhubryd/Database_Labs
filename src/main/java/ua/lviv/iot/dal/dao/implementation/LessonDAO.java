package ua.lviv.iot.dal.dao.implementation;

import ua.lviv.iot.dal.dao.GeneralDAO;
import ua.lviv.iot.model.entity.Lesson;

public class LessonDAO extends GeneralDAO<Lesson, Integer> {
    public LessonDAO(){
        super(Lesson.class);
    }
}
