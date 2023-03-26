/**
 * @author Troitskaya Tamara (cgsg-tt6)
 */
package management;

import commands.DefaultInputCommand;
import task.Route;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Stores the collection.
 */
public class CollectionManager {
    AskInputManager aim = new AskInputManager(null);
    CommandManager cm = new CommandManager(this, aim);
    InputManager silentInput = new InputManager(null);
    CommandManager silentCommands = new CommandManager(this, silentInput);

    private static Stack<Route> stack = new Stack<>();
    private final String type;
    private final java.time.LocalDateTime creationDate;
    private static Long lastId = 0L;

    // for 'add'
    public static Long getLastId() {
        return lastId;
    }

    public static void setLastId(Long Id) {
        lastId = Id;
    }

    // for 'show'
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getType() {
        return type;
    }

    public Stack<Route> stack() {
        return stack;
    }

    public CollectionManager() {
        type = "Stack";
        creationDate = LocalDateTime.now();
        // initialization:
        DefaultInputCommand defaultInp = new DefaultInputCommand("defaultcollection.txt", this);
        defaultInp.execute();
    }

    /**
     * Gets the management from file.
     */
    /*
    public void execute_script(Scanner sc) {
        try {
            String path = sc.nextLine();
            File file = new File(path);
            Scanner fileScanner = new Scanner(file);
            loop(fileScanner);
        } catch (FileNotFoundException e) {
            boolean loop = true;
            do {
                try {
                    System.out.println("execute script: " + e.getMessage());
                    System.err.println("Input filename again:");
                    execute_script(sc);
                    loop = false;
                } catch (NumberFormatException | InputMismatchException exception){
                    loop = true;
                }
            } while (loop);
        }
    }
*/
    /**
     * Loop of client commands.
     */
    /*
    public void loop(Scanner scanner) {
        aim.setScanner(scanner);
        while (scanner.hasNext()) {
            String command = scanner.nextLine();
            switch (command) {
                case "help", "info", "clear", "exit", "show",  "add", "insert_at", "update", "save",
                        "add_if_max", "remove_by_id", "remove_lower", "print_field_descending_distance",
                        "filter_greater_than_distance", "group_counting_by_from" -> {
                    cm.getCommands().get(command).execute();
                }
                case "execute_script" -> {
                    System.out.println("Input filename");
                    execute_script(scanner);
                    cm.setScanner(new Scanner(System.in));
                }
                default -> System.out.println(command + ": this command doesn't exist yet.");
            }
        }
        scanner.close();
    }
*/
}
