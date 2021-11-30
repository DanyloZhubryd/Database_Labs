package ua.lviv.iot.controller.implementation;

import ua.lviv.iot.controller.GeneralController;
import ua.lviv.iot.model.dal.dao.implementation.WorkerDAO;
import ua.lviv.iot.model.entity.Worker;

public class WorkerController extends GeneralController<Worker> {
    public WorkerController(){
        super(new WorkerDAO());
    }
}
