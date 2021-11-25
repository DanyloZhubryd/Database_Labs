package ua.lviv.iot.controller;

import java.sql.SQLException;
import java.util.List;

public interface AbstractController <Entity, Id> {
    List<Entity> getAll() throws SQLException;
    Entity get(Id id) throws SQLException;
    boolean update(Id id, Entity e) throws SQLException;
    boolean delete(Id id) throws SQLException;
    boolean create(Entity e) throws SQLException;
}
