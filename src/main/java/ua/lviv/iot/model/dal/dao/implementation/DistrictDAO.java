package ua.lviv.iot.model.dal.dao.implementation;

import ua.lviv.iot.model.dal.dao.GeneralDAO;
import ua.lviv.iot.model.entity.District;

public class DistrictDAO extends GeneralDAO<District> {
    public DistrictDAO(){
        super(District.class);
    }
}
