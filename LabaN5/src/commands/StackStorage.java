package commands;

/**
 * @author Troitskaya Tamara (TT6)
 * 28.02.2023
 */

import task.Route;

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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getType() {
        return type;
    }

    public int size() {
        return stack.size();
    }
}
