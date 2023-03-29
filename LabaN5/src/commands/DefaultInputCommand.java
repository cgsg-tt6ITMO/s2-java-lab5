/**
 * @author Troitskaya Tamara (cgsg-tt6)
 */
package commands;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import management.CollectionManager;
import task.Route;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

/**
 * Initialize collection with elements from default file.
 */
public class DefaultInputCommand implements Command {
    private final String filename;
    private final CollectionManager storage;

    /**
     * Set FileName, silent input manager and storage to initialize.
     */
    public DefaultInputCommand(String filename, CollectionManager collectionManager) {
        this.filename = filename;
        this.storage = collectionManager;
    }

    /**
     * Input from json.
     */
    @Override
    public void execute() {
        Gson gson = new Gson();
        storage.stack().clear();
        try (Scanner sc = new Scanner(new File(filename))) {
            Stack<Route> srut = gson.fromJson(sc.nextLine().trim(), new TypeToken<Stack<Route>>() {}.getType());
            for (var r : srut) {
                System.out.println("Route Id:      " + r.getId() + "\nName:          " + r.getName()
                        //+ "\nCreation date: " + r.getCreationDate()
                        + "\nCoordinates:   " + r.getCoordinates().getX() + " " + r.getCoordinates().getY()
                        + "\nLocation From: " + r.getFrom().getName() + " " + r.getFrom().getX() + " " + r.getFrom().getY() + " " + r.getFrom().getZ()
                        + "\nLocation To:   " + r.getTo().getName() + " " + r.getTo().getX() + " " + r.getTo().getY() + " " + r.getTo().getZ()
                        + "\nDistance:      " + r.getDistance() + "\n");
            }
            storage.stack().addAll(srut);
            System.out.println("SUCCESS");
        } catch (IOException exception) {
            System.err.println("default_input: " + exception.getMessage());
        }
    }

}
