package commands;

import task.Route;

import java.util.Stack;

/**
 * Можно удалить этот класс и вместо него в свиче в клиенте просто вызывать s.clear();
 * Эти реализации абсолютно делают одинаково.
 * Хотя чтоб всё было в одном стиле...
 */
public class Clear {
    public static void clear(Stack<Route> s) {
        s.clear();
    }
}
