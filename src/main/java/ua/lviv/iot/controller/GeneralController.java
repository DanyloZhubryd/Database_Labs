package ua.lviv.iot.controller;

import ua.lviv.iot.dal.dao.AbstractDAO;

import java.sql.SQLException;
import java.util.List;

public class GeneralController<Entity, Id> implements AbstractController<Entity, Id>{
    private final AbstractDAO<Entity, Id> dao;

    public GeneralController(AbstractDAO<Entity, Id> dao){
        this.dao = dao;
    }

    @Override
    public List<Entity> getAll() throws SQLException {
        return dao.getAll();
    }

    @Override
    public Entity get(Id id) throws SQLException {
        return dao.get(id);
    }

    @Override
    public boolean update(Id id, Entity entity) throws SQLException {
        return dao.update(id, entity);
    }

    @Override
    public boolean delete(Id id) throws SQLException {
        return dao.delete(id);
    }

    @Override
    public boolean create(Entity entity) throws SQLException {
        return dao.create(entity);
    }
}