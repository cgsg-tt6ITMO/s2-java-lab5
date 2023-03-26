/**
 * @author Troitskaya Tamara (cgsg-tt6)
 */
package commands;

import management.CollectionManager;
import management.Input;
import management.InputManager;
import task.Route;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
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
     * Input elements from file "defaultcollection.txt".
     */
    @Override
    public void execute() {
        Stack<Route> stack = storage.stack();
        File file = new File(filename);
        try {
            Scanner sc = new Scanner(file).useLocale(Locale.US);
            Input inputManager = new InputManager(sc);
            int q = sc.nextInt();
            sc.nextLine();
            while (q > 0) {
                stack.add(inputManager.inpRoute());
                q--;
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
