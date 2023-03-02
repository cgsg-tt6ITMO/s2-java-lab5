/**
 * @author Troitskaya Tamara (TT6)
 */

import commands.*;
import task.Route;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.exit;

/**
 * This class is going to handle the commands that the client gives.
 */

public class Client {
    /**
     * This method is for inputting client's commands and handling them.
     */
    public void run() {
        // сначала должен быть ввод коллекции из файла
        try {
            File f = new File("inp.txt");
            Scanner scanner = new Scanner(f).useLocale(Locale.US);

            StackStorage storage = new StackStorage();
            Stack<Route> stack = storage.stack();

            Add.defaultInputFromFile(stack, "defaultcollection.txt");
            Show.show(stack);

            while (scanner.hasNext()) {
                String command = scanner.nextLine();
                switch (command) {
                    case "help" -> Help.help();
                    case "info" -> Info.info(storage);
                    // но есть ещё возможность Clear.clear(stack);
                    case "clear" -> stack.clear();
                    case "save" -> {
                        String outputfile = "out.txt";
                        Save.save(outputfile, stack);
                    }
                    case "add" -> {
                        // System.out.println("From file? (y/n)");
                        String answer = scanner.nextLine();
                        if (answer.equals("y")) {
                            // System.out.println("Input the path ");
                            Add.addOneElementFromFile(stack, scanner.nextLine());
                        } else if (answer.equals("n")){
                            Add.add(stack);
                        } else {
                            System.out.println(answer + " is incorrect answer");
                        }
                    }
                    case "exit" -> exit(0);
                    case "show" -> Show.show(stack);
                    default -> System.out.println(command + ": this command doesn't exist yet.");
                }
            }
            scanner.close();
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
