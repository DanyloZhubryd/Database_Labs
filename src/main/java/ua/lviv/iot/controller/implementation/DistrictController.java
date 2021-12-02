package ua.lviv.iot.controller.implementation;

import ua.lviv.iot.controller.GeneralController;
import ua.lviv.iot.dal.dao.implementation.DistrictDAO;
import ua.lviv.iot.model.entity.District;

public class DistrictController extends GeneralController<District, String> {
    public DistrictController(){
        super(new DistrictDAO());
    }
}
