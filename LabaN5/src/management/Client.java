/**
 * @author Troitskaya Tamara (cgsg-tt6)
 */
package management;

import java.util.Locale;
import java.util.Scanner;

/**
 * This class handles the commands that the client inputs in loop.
 */
public class Client {

    /**
     * This method is for inputting client's commands and handling them.
     */
    public void run() {
        CollectionManager storage = new CollectionManager();
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        AskInputManager askInputManager = new AskInputManager(scanner);
        CommandManager commandManager = new CommandManager(storage, askInputManager);

        while (scanner.hasNext()) {
            String command = scanner.nextLine();
            if (commandManager.getCommands().containsKey(command)) {
                commandManager.getCommands().get(command).execute();
            } else {
                System.out.println(command + ": this command doesn't exist yet.");
            }
        }
        scanner.close();
    }
}
