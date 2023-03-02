package commands;

/**
 * @author Troitskaya Tamara (TT6)
 * 28.02.2023
 */

import task.Route;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Stack;

public class StackStorage {
    private static Stack<Route> stack = new Stack<>();
    //тип, дата инициализации, количество элементов и т.д
    private final String type;
    private final java.time.LocalDateTime creationDate;
    private static int lastId = 0;

    public static int getLastId() {
        return lastId;
    }

    public static void setLastId(int Id) {
        lastId = Id;
    }

    public Stack<Route> stack() {
        return stack;
    }

    public StackStorage() {
        type = "Stack";
        creationDate = LocalDateTime.now();
    }

    public void show() {
        System.out.println("SHOW COLLECTION:");
        for (var el : stack) {
            System.out.println("ID: \t\t" + el.getId() + "\nName: \t\t" + el.getName()
                    + "\nDistance: \t" + el.getDistance() + "\n");
        }
    }

    public void save(String outp) {
        System.out.println("SAVE COLLECTION:\nСохранение производится в файл " + outp + "\n");
        try {
            BufferedWriter output = new BufferedWriter(new FileWriter(outp));

            for (var el : stack) {
                output.write(el.getId() + " " + el.getName()
                        + " " + el.getDistance() + "\n");
            }
            output.close();
        }
        catch (IOException e) {
            System.err.println("Exception while output: " + e.getMessage());
        }
    }

    /**
     * Prints to screen all the commands available.
     */
    public void help() {
        System.out.println("""
                COMMANDS AVAILABLE:
                 - help: prints the list of all commands;
                 - add: adds your element to the collection;
                 - info: prints info about the collection;
                 - save: writes the collection data to file;
                 - clear: deletes all the elements in collection;
                 - show: writes all the elements to console;
                 - execute_script: inputs elements from file;
                 - exit;
                 - other.
                """);
    }

    /**
     * Prints to screen all the attributes of the collection.
     */
    public void info() {
        LocalDateTime date = creationDate;
        System.out.println("COLLECTION INFO:\n"
                + "creation time: " + date.getHour() + ":" + (date.getMinute() > 9 ? date.getMinute() : "0" + date.getMinute())
                + "\ntype of storage: " + type + "\nnumber of elements: " + stack.size() + "\n");
    }
}
