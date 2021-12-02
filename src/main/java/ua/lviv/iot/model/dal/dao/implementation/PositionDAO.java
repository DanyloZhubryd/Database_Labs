package ua.lviv.iot.model.dal.dao.implementation;

import ua.lviv.iot.model.dal.dao.GeneralDAO;
import ua.lviv.iot.model.entity.Position;

public class PositionDAO extends GeneralDAO<Position> {
    public PositionDAO(){
        super(Position.class);
    }
}
