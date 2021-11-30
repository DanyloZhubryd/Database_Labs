package ua.lviv.iot.model.dal.dao.implementation;

import ua.lviv.iot.model.dal.dao.GeneralDAO;
import ua.lviv.iot.model.entity.Worker;

public class WorkerDAO extends GeneralDAO<Worker> {
    public WorkerDAO(){
        super(Worker.class);
    }
}
