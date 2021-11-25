package ua.lviv.iot.dal.dao.implementation;

import ua.lviv.iot.dal.dao.GeneralDAO;
import ua.lviv.iot.model.entity.ChildGroup;

public class ChildGroupDAO extends GeneralDAO<ChildGroup, Integer> {
    public ChildGroupDAO(){
        super(ChildGroup.class);
    }
}
