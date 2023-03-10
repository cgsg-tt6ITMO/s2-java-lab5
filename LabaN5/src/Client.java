/**
 * @author Troitskaya Tamara (TT6)
 * 10.03.2023
 */

import commands.*;
import task.Route;

import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.exit;

/**
 * This class handles the commands that the client inputs in loop.
 */
public class Client {

    /**
     * This method is for inputting client's commands and handling them.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        StackStorage storage = new StackStorage();
        Stack<Route> stack = storage.stack();

        storage.defaultInputFromFile("defaultcollection.txt");
        storage.show();

        while (scanner.hasNext()) {
            String command = scanner.nextLine();
            switch (command) {
                case "help" -> storage.help();
                case "info" -> storage.info();
                case "clear" -> {
                    stack.clear();
                    System.out.println("Now the collection is empty.\n");
                }
                case "save" -> {
                    String outputfile = "out.txt";
                    storage.save(outputfile);
                }
                case "add" -> {
                    storage.add();
                }
                case "exit" -> exit(0);
                case "show" -> storage.show();
                case "execute_script file_name" -> {
                    System.out.println("Soon...");
                }
                default -> System.out.println(command + ": this command doesn't exist yet.");
            }
        }
        scanner.close();
    }
}
