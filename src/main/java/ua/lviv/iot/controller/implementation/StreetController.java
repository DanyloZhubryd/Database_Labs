package ua.lviv.iot.controller.implementation;

import ua.lviv.iot.controller.GeneralController;
import ua.lviv.iot.dal.dao.implementation.StreetDAO;
import ua.lviv.iot.model.entity.Street;

public class StreetController extends GeneralController<Street, String> {
    public StreetController(){
        super(new StreetDAO());
    }
}
