package ua.lviv.iot.model.dal.dao.implementation;

import ua.lviv.iot.model.dal.dao.GeneralDAO;
import ua.lviv.iot.model.entity.Child;

public class ChildDAO extends GeneralDAO<Child> {
    public ChildDAO(){
        super(Child.class);
    }
}
