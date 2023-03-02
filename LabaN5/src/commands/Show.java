package commands;

import task.Route;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Show {

    public static void show(Stack<Route> r) {
        System.out.println("SHOW COLLECTION:");
        for (var el : r) {
            System.out.println("ID: \t\t" + el.getId() + "\nName: \t\t" + el.getName()
                    + "\nDistance: \t" + el.getDistance() + "\n");
        }
    }
}
