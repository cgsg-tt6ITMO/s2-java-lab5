/**
 * @author Troitskaya Tamara (TT6)
 */

package commands;

import java.time.LocalDateTime;

/**
 * Info command realization for Client.
 */
public class Info {

    /**
     * Prints to screen all the attributes of the collection.
     */
    public static void info(StackStorage stackStorage) {
        LocalDateTime date = stackStorage.getCreationDate();
        System.out.println("COLLECTION INFO:\n"
                + "creation time: " + date.getHour() + ":" + (date.getMinute() > 9 ? date.getMinute() : "0" + date.getMinute())
                + "\ntype of storage: " + stackStorage.getType()
                + "\nnumber of elements: " + stackStorage.size() + "\n");
    }
}
