/**
 * @author Troitskaya Tamara (TT6)
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
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        StackStorage storage = new StackStorage();

        storage.defaultInputFromFile("defaultcollection.txt");
        storage.show();
        storage.help();
        storage.loop(scanner);
    }
}
