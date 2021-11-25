package ua.lviv.iot.dal.dao.implementation;

import ua.lviv.iot.dal.dao.GeneralDAO;
import ua.lviv.iot.model.entity.Position;

public class PositionDAO extends GeneralDAO<Position, Integer> {
    public PositionDAO(){
        super(Position.class);
    }
}
