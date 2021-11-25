package ua.lviv.iot.controller.implementation;

import ua.lviv.iot.controller.GeneralController;
import ua.lviv.iot.dal.dao.implementation.ChildDAO;
import ua.lviv.iot.model.entity.Child;

public class ChildController extends GeneralController<Child, String> {
    public ChildController(){
        super(new ChildDAO());
    }
}

