package ua.lviv.iot.dal.dao.implementation;

import ua.lviv.iot.dal.dao.GeneralDAO;
import ua.lviv.iot.model.entity.Worker;

public class WorkerDAO extends GeneralDAO<Worker, String> {
    public WorkerDAO(){
        super(Worker.class);
    }
}
