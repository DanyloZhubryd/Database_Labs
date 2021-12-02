package ua.lviv.iot.view;

import ua.lviv.iot.controller.GeneralController;
import ua.lviv.iot.model.manager.Manager;

import javax.persistence.EntityNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ViewAPI<Entity, Id> {
    private final GeneralController<Entity, Id> controller;
    private final Class<Entity> entity;
    private final Manager<Entity, Id> manager;
    private final Scanner input = new Scanner(System.in);

    public ViewAPI(Class<Entity> entity, GeneralController<Entity, Id> controller){
        this.controller = controller;
        this.entity = entity;
        manager = new Manager<>(entity);
    }

    public void create(){
        Entity entityCreate;
        List<Field> fields= manager.getInputableColumns();
        try {
            entityCreate = entity.getConstructor().newInstance();
            for (Field field : fields){
                System.out.println(field.getName().toLowerCase(Locale.ROOT) + ": ");
                field.setAccessible(true);
                input(field, entityCreate);
            }
            controller.create(entityCreate);
        } catch (InvocationTargetException | InstantiationException |
                IllegalAccessException | NoSuchMethodException | SQLException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void update(){
        System.out.println("Enter row id to update:");
        Entity entityUpdate;
        Id id = (Id) input.nextLine();
        List<Field> fields = manager.getInputableColumns();
        try {
            entityUpdate = entity.getConstructor().newInstance();
            for (Field field: fields){
                System.out.println(field.getName().toLowerCase(Locale.ROOT) + ": ");
                field.setAccessible(true);
                input(field, entityUpdate);
            }
            if(controller.update(id, entityUpdate))
                System.out.println("Row with id \"" + id + "\" have been successfully updated");

        } catch (SQLException | InvocationTargetException | InstantiationException |
                IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void delete(){
        System.out.println("Enter row id to delete:");
        Id id = (Id) input.nextLine();
        try {
            if(controller.delete(id))
                System.out.println("Row with id \"" + id + "\" have been successfully deleted");
        } catch (SQLException | EntityNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void getAll(){
        try {
            List<Entity> entities = controller.getAll();
            if(entities != null){
                for (Entity entity: entities)
                    System.out.println(entity.toString());
            } else {
                System.out.println("Nothing found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void get(){
        System.out.println("Enter row id to get:");
        Id id = (Id) input.nextLine();
        try{
            Entity entity = controller.get(id);
            if (entity != null)
                System.out.println(entity.toString());
            else
                System.out.println("Entity with such id doesn't exist");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void input(Field field, Entity entity) throws IllegalAccessException {
        String input = this.input.nextLine();
        Class fieldType = field.getType();
        if (fieldType == Integer.class){
            field.set(entity, Integer.parseInt(input));
        } else if (fieldType == Double.class){
            field.set(entity, Double.parseDouble(input));
        } else if (fieldType == String.class){
            field.set(entity, input);
        } else if (fieldType == LocalDate.class){
            field.set(entity, input);
        } else if (fieldType == LocalTime.class){
            field.set(entity, input);
        }
    }
}
