package ua.lviv.iot.controller.implementation;

import ua.lviv.iot.controller.GeneralController;
import ua.lviv.iot.model.dal.dao.implementation.KindergardenDAO;
import ua.lviv.iot.model.entity.Kindergarden;

public class KindergardenController extends GeneralController<Kindergarden> {
    public KindergardenController(){
        super(new KindergardenDAO());
    }
}
