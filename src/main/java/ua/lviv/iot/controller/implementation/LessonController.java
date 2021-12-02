package ua.lviv.iot.controller.implementation;

import ua.lviv.iot.controller.GeneralController;
import ua.lviv.iot.dal.dao.implementation.LessonDAO;
import ua.lviv.iot.model.entity.Lesson;

public class LessonController extends GeneralController<Lesson, Integer> {
    public LessonController(){
        super(new LessonDAO());
    }
}
