package ua.lviv.iot.dal.dao.implementation;

import ua.lviv.iot.dal.dao.GeneralDAO;
import ua.lviv.iot.model.entity.Child;

public class ChildDAO extends GeneralDAO<Child, String> {
    public ChildDAO(){
        super(Child.class);
    }
}
