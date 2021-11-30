package ua.lviv.iot.model.dal.dao.implementation;

import ua.lviv.iot.model.dal.dao.GeneralDAO;
import ua.lviv.iot.model.entity.Lesson;

public class LessonDAO extends GeneralDAO<Lesson> {
    public LessonDAO(){
        super(Lesson.class);
    }
}
