package ua.lviv.iot.controller;

import java.sql.SQLException;
import java.util.List;

public interface AbstractController <Entity> {
    List<Entity> getAll() throws SQLException;
    Entity get(Integer id) throws SQLException;
    boolean update(Integer id, Entity e) throws SQLException;
    boolean delete(Integer id) throws SQLException;
    boolean create(Entity e) throws SQLException;
}
