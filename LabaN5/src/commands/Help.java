/**
 * @author Troitskaya Tamara (TT6)
 */

package commands;

/**
 * Help command realization for Client.
 */
public class Help {//implements Executable {

    /**
     * Prints to screen all the commands available.
     */
    public static void help() {
        System.out.println("""
                COMMANDS AVAILABLE:
                 - help: prints the list of all commands;
                 - add: adds your element to the collection;
                 - info: prints info about the collection;
                 - save: writes the collection data to file;
                 - exit;
                 - clear: deletes all the elements in collection;
                 - other.
                """);
    }
}
