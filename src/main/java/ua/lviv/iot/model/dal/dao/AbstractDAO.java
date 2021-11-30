package ua.lviv.iot.model.dal.dao;

import java.sql.SQLException;
import java.util.List;

public interface AbstractDAO<Entity> {

    Entity get(Integer id) throws SQLException;
    List<Entity> getAll() throws SQLException;
    boolean create(Entity entity) throws SQLException;
    boolean update(Integer id, Entity entity) throws SQLException;
    boolean delete(Integer id) throws SQLException;
}
