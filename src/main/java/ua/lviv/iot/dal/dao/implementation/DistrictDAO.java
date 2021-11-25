package ua.lviv.iot.dal.dao.implementation;

import ua.lviv.iot.dal.dao.GeneralDAO;
import ua.lviv.iot.model.entity.District;

public class DistrictDAO extends GeneralDAO<District, String> {
    public DistrictDAO(){
        super(District.class);
    }
}
