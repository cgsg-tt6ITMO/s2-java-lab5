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
        try {
            File f = new File("inp.txt");
            Scanner scanner = new Scanner(f).useLocale(Locale.US);

            StackStorage storage = new StackStorage();
            Stack<Route> stack = storage.stack();

            while (scanner.hasNext()) {
                String s = scanner.nextLine();
                switch (s) {
                    case "help" -> Help.help();
                    case "info" -> Info.info(storage);
                    // но есть ещё возможность Clear.clear(stack);
                    case "clear" -> stack.clear();
                    case "save" -> {
                        System.out.println("Сохранение производится в файл out.txt");
                        String outputfile = "out.txt";
                        Save.save(outputfile, stack);
                    }
                    case "add" -> {
                        // add from file
                        Add.add(stack);
                    }
                    case "exit" -> exit(0);
                    default -> System.out.println(s + " The command doesn't exist yet.");
                }
            }
            scanner.close();
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
