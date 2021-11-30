package ua.lviv.iot.model.dal.dao.implementation;

import ua.lviv.iot.model.dal.dao.GeneralDAO;
import ua.lviv.iot.model.entity.Street;

public class StreetDAO extends GeneralDAO<Street> {
    public StreetDAO(){
        super(Street.class);
    }
}
