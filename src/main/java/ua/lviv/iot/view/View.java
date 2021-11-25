package ua.lviv.iot.view;


import ua.lviv.iot.controller.GeneralController;
import ua.lviv.iot.controller.implementation.*;
import ua.lviv.iot.model.entity.*;

import java.util.Scanner;

public class View {
    private static Scanner input = new Scanner(System.in);
    public static void view(){
        choose_table:
        while (true){
            Class entity;
            GeneralController controller;
            ViewAPI viewOperations;

            System.out.println("Choose your table:");
            System.out.println("1: street");
            System.out.println("2: district");
            System.out.println("3: address");
            System.out.println("4: kindergarden");
            System.out.println("5: worker");
            System.out.println("6: position");
            System.out.println("7: child");
            System.out.println("8: child_group");
            System.out.println("9: lesson");
            System.out.println("e: Exit program");
            String table = input.nextLine();

            switch (table){
                case "1":
                    entity = Street.class;
                    controller = new StreetController();
                    break;
                case "2":
                    entity = District.class;
                    controller = new DistrictController();
                    break;
                case "3":
                    entity = Address.class;
                    controller = new AddressController();
                    break;
                case "4":
                    entity = Kindergarden.class;
                    controller = new KindergardenController();
                    break;
                case "5":
                    entity = Worker.class;
                    controller = new WorkerController();
                    break;
                case "6":
                    entity = Position.class;
                    controller = new PositionController();
                    break;
                case "7":
                    entity = Child.class;
                    controller = new ChildController();
                    break;
                case "8":
                    entity = ChildGroup.class;
                    controller = new ChildGroupController();
                    break;
                case "9":
                    entity = Lesson.class;
                    controller = new LessonController();
                    break;
                case "e":
                    System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-\n");
                    break choose_table;
                default:
                    System.out.println("Invalid key:" + table);
                    System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-\n");
                    continue;
            }
            viewOperations = new ViewAPI(entity, controller);
            System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-\n");
            boolean shallWeContinue = true;
            while (shallWeContinue) {
                System.out.println("Choose your next action with" + entity.getSimpleName() + "table:");
                System.out.println("1: Create new row");
                System.out.println("2: Update row");
                System.out.println("3: Delete row");
                System.out.println("4: Get row");
                System.out.println("5: Get all rows");
                System.out.println("E: Exit");
                String action = input.nextLine();

                switch (action) {
                    case "1":
                        viewOperations.create();
                        break;
                    case "2":
                        viewOperations.update();
                        break;
                    case "3":
                        viewOperations.delete();
                        break;
                    case "4":
                        viewOperations.get();
                        break;
                    case "5":
                        viewOperations.getAll();
                        break;
                    case "e":
                        shallWeContinue = false;
                        System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-\n");
                        break;
                    default:
                        System.out.println("Invalid key:" + table);
                        System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-\n");
                }
                System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-\n");
            }
        }
    }
}
