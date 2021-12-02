package ua.lviv.iot.dal.dao.implementation;

import ua.lviv.iot.dal.dao.GeneralDAO;
import ua.lviv.iot.model.entity.Kindergarden;

public class KindergardenDAO extends GeneralDAO<Kindergarden, Integer> {
    public KindergardenDAO(){
        super(Kindergarden.class);
    }
}
