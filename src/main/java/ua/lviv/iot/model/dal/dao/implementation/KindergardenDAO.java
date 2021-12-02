package ua.lviv.iot.model.dal.dao.implementation;

import ua.lviv.iot.model.dal.dao.GeneralDAO;
import ua.lviv.iot.model.entity.Kindergarden;

public class KindergardenDAO extends GeneralDAO<Kindergarden> {
    public KindergardenDAO(){
        super(Kindergarden.class);
    }
}
