package ua.lviv.iot.controller.implementation;

import ua.lviv.iot.controller.GeneralController;
import ua.lviv.iot.model.dal.dao.implementation.PositionDAO;
import ua.lviv.iot.model.entity.Position;

public class PositionController extends GeneralController<Position> {
    public PositionController(){
        super(new PositionDAO());
    }
}
