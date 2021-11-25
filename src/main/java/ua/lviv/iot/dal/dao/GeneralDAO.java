package ua.lviv.iot.dal.dao;

import ua.lviv.iot.dal.persistant.ConnectionDB;
import ua.lviv.iot.model.manager.Manager;
import ua.lviv.iot.model.transformer.Transformer;

import javax.persistence.EntityNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class GeneralDAO<Entity, Id> implements AbstractDAO<Entity, Id>{

    private final Manager<Entity, Id> manager;
    private final Transformer<Entity, Id> transformer;
    private final Class<Entity> entityClass;

    public GeneralDAO(Class<Entity> entityClass){
        this.entityClass = entityClass;
        this.manager = new Manager<>(entityClass);
        this.transformer = new Transformer<>(entityClass);
    }

    @Override
    public Entity get(Id id) throws SQLException{
        Entity searched = null;
        Connection connection = ConnectionDB.getConnection();
        String tableName = manager.getTableName();
        String primaryKeyName = manager.getPrimaryKeyName();
        String statement = String.format("SELECT * FROM %s WHERE %s=%s",
                tableName, primaryKeyName, id);
        try(PreparedStatement preparedStatement = connection.prepareStatement(statement)) {
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();
                searched = transformer.castResultSetToEntity(resultSet);
            } catch (InvocationTargetException | InstantiationException |
                    IllegalAccessException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return searched;
    }

    @Override
    public List<Entity> getAll() throws SQLException {
        List<Entity> entityList = new LinkedList<>();
        Connection connection = ConnectionDB.getConnection();
        String tableName = manager.getTableName();
        String statement = String.format("SELECT * FROM %s",
                tableName);
        try(PreparedStatement preparedStatement = connection.prepareStatement(statement)) {
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()){
                    entityList.add(transformer.castResultSetToEntity(resultSet));
                }
            } catch (InvocationTargetException | InstantiationException |
                    IllegalAccessException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return entityList;
    }

    @Override
    public boolean create(Entity entity) throws SQLException {
        try(Connection connection = ConnectionDB.getConnection()) {
            String tableName = manager.getTableName();
            String columnNames = manager.getInputableColumnsNamesSeparatedByCommas();
            String values = manager.getCreateColumnsString(entity);
            String statement = String.format("INSERT INTO %s(%s) VALUES(%s);",
                    tableName, columnNames, values);
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            if (preparedStatement.executeUpdate() == 0)
                throw new IllegalStateException();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean delete(Id id) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        String tableName = manager.getTableName();
        String primaryKeyName = manager.getPrimaryKeyName();
        String statement = String.format("DELETE FROM %s WHERE %s=%s;",
                tableName, primaryKeyName, id);
        PreparedStatement preparedStatement = connection.prepareStatement(statement);
        if (preparedStatement.executeUpdate() == 0){
            throw new EntityNotFoundException();
        }
        return true;
    }

    @Override
    public boolean update(Id id, Entity entity) throws SQLException {
        try(Connection connection = ConnectionDB.getConnection()) {
            String tableName = manager.getTableName();
            String primaryKeyName = manager.getPrimaryKeyName();
            String updateColumns = manager.getUpdateColumnsString(entity);
            String statement = String.format("UPDATE %s SET %s WHERE %s=%s;",
                    tableName, updateColumns, primaryKeyName, id);
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            if (preparedStatement.executeUpdate() == 0)
                throw new EntityNotFoundException();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return true;
    }
}
