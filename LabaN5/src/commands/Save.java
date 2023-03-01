package commands;

import task.Route;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;

public class Save {

    public static void save(String outp, Stack<Route> r) {
        try {
            BufferedWriter output = new BufferedWriter(new FileWriter(outp));

            for (var el : r) {
                output.write(el.getId() + " " + el.getName()
                        + " " + el.getDistance() + "\n");
            }
            output.close();
        }
        catch (IOException e) {
            System.err.println("Exception while output");
        }
    }
}
