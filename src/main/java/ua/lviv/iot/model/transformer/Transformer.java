package ua.lviv.iot.model.transformer;


import ua.lviv.iot.model.manager.Manager;

import javax.persistence.Column;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Transformer<Entity, Id>{
    private final Manager<Entity, Id> manager;

    public Transformer(Class<Entity> entityClass) {
        this.manager = new Manager<>(entityClass);
    }

    public Manager<Entity, Id> getManager() {
        return manager;
    }

    public Entity castResultSetToEntity(ResultSet resultSet) throws InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, SQLException{
        Entity entity = manager.getEntityClass().getConstructor().newInstance();
        for (Field field: manager.getColumns()){
            String name = field.getAnnotation(Column.class).name();
            field.setAccessible(true);
            Class<?> fieldType = field.getType();
            field.set(entity, resultSet.getObject(name, fieldType));
        }
        return entity;
    }
}
