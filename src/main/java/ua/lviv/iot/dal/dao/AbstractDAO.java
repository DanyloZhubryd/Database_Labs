package ua.lviv.iot.dal.dao;

import java.sql.SQLException;
import java.util.List;

public interface AbstractDAO<Entity, Id> {

    Entity get(Id id) throws SQLException;
    List<Entity> getAll() throws SQLException;
    boolean create(Entity entity) throws SQLException;
    boolean update(Id id, Entity entity) throws SQLException;
    boolean delete(Id id) throws SQLException;
}
