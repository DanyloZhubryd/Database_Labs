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
            if (fieldType == String.class)
                field.set(entity, resultSet.getString(name));
            else if (fieldType == Integer.class)
                field.set(entity, resultSet.getInt(name));
            else if (fieldType == Float.class)
                field.set(entity, resultSet.getDouble(name));
            else if (fieldType == LocalDate.class)
                field.set(entity, resultSet.getDate(name));
            else if (fieldType == LocalTime.class)
                field.set(entity, resultSet.getTime(name));
        }
        return entity;
    }
}
