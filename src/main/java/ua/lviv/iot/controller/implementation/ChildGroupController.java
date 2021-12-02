package ua.lviv.iot.controller.implementation;

import ua.lviv.iot.controller.GeneralController;
import ua.lviv.iot.dal.dao.implementation.ChildGroupDAO;
import ua.lviv.iot.model.entity.ChildGroup;

public class ChildGroupController extends GeneralController<ChildGroup, Integer> {
    public ChildGroupController(){
        super(new ChildGroupDAO());
    }
}
