package ua.lviv.iot.model.manager;

import lombok.AllArgsConstructor;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
public class Manager<Entity, Id> {
    private final Class<Entity> eClass;
    private final Field[] fields;

    public Manager(Class<Entity> eClass) {
        this.eClass = eClass;
        this.fields = eClass.getDeclaredFields();
    }

    public Class<Entity> getEntityClass() {
        return this.eClass;
    }

    public String getTableName() {
        return this.eClass.getAnnotation(Table.class).name();
    }

    public String getPrimaryKeyName() {
        for (Field field : this.fields) {
            if (field.isAnnotationPresent(javax.persistence.Id.class)) {
                return field.getAnnotation(Column.class).name();
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public Id getPrimaryKey(Entity entity) throws IllegalArgumentException, IllegalAccessException {
        for (Field field : this.fields) {
            if (field.isAnnotationPresent(javax.persistence.Id.class)) {
                field.setAccessible(true);
                return (Id) field.get(entity);
            }
        }
        return null;
    }

    public List<Field> getColumns() {
        List<Field> columns = new ArrayList<>();
        for (Field field : this.fields) {
            if (field.isAnnotationPresent(Column.class)) {
                columns.add(field);
            }
        }
        return columns;
    }

    public List<String> getColumnsName() {
        List<String> columnsNames = new LinkedList<String>();
        List<Field> columns = this.getColumns();
        for (Field column : columns) {
            columnsNames.add(column.getAnnotation(Column.class).name());
        }
        return columnsNames;
    }

    public List<Field> getInputableColumns() {
        List<Field> inputableColumns = new LinkedList<Field>();
        List<Field> columns = this.getColumns();
        for (Field column : columns) {
            if (!column.isAnnotationPresent(GeneratedValue.class)) {
                inputableColumns.add(column);
            }
        }
        return inputableColumns;
    }

    public List<String> getInputableColumnsNames() {
        List<String> inputableColumnsNames = new LinkedList<String>();
        List<Field> inputableColumns = this.getInputableColumns();
        for (Field column : inputableColumns) {
            inputableColumnsNames.add(column.getAnnotation(Column.class).name());
        }
        return inputableColumnsNames;
    }

    public Field setColumnValueByName(Entity entity, String fieldName, Object fieldValue)
            throws IllegalArgumentException, IllegalAccessException {
        List<Field> columns = this.getInputableColumns();
        for (Field column : columns) {
            if (column.getName().equals(fieldName)) {
                column.setAccessible(true);
                column.set(entity, fieldValue);
                return column;
            }
        }
        return null;
    }

    public String getInputableColumnsNamesSeparatedByCommas() {
        return String.join(", ", this.getInputableColumnsNames());
    }

    public String getCreateColumnsString(Entity entity) throws IllegalArgumentException, IllegalAccessException {
        StringBuilder createColumnsString = new StringBuilder();
        List<Field> columns = this.getInputableColumns();
        for (Field column : columns) {
            column.setAccessible(true);
            if (column.getType() == LocalDate.class
                    || column.getType() == LocalTime.class
                    || column.getType() == String.class) {
                createColumnsString.append("'");
                createColumnsString.append(column.get(entity).toString());
                createColumnsString.append("'");
            } else {
                createColumnsString.append(column.get(entity).toString());
            }
            createColumnsString.append(", ");
        }
        createColumnsString.delete(createColumnsString.length() - 2, createColumnsString.length() - 1);
        return createColumnsString.toString();
    }

    public String getUpdateColumnsString(Entity entity) throws IllegalArgumentException, IllegalAccessException {
        StringBuilder updateColumnsString = new StringBuilder();
        List<Field> columns = this.getInputableColumns();
        List<String> columnsNames = this.getInputableColumnsNames();
        for (int i = 0; i < columns.size(); i++) {
            Field column = columns.get(i);
            String columnName = columnsNames.get(i);
            column.setAccessible(true);
            updateColumnsString.append(columnName);
            updateColumnsString.append("=");
            if (column.getType() == LocalDate.class
                    || column.getType() == LocalTime.class
                    || column.getType() == String.class) {
                updateColumnsString.append("'");
                updateColumnsString.append(column.get(entity).toString());
                updateColumnsString.append("'");
            } else {
                updateColumnsString.append(column.get(entity).toString());
            }
            updateColumnsString.append(", ");
        }
        updateColumnsString.delete(updateColumnsString.length() - 2, updateColumnsString.length() - 1);
        return updateColumnsString.toString();
    }
}
