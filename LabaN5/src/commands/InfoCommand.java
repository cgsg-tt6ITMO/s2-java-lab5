/**
 * @author Troitskaya Tamara (cgsg-tt6)
 */
package commands;

import management.CollectionManager;

import java.time.LocalDateTime;

/**
 * Handle 'info' method.
 */
public class InfoCommand extends AbstractCommand implements Command{
    private CollectionManager collectionManager;

    /**
     * Set name and description for 'info' command.
     */
    public InfoCommand(CollectionManager storage) {
        super("info", "prints info about the collection;");
        this.collectionManager = storage;
    }

    /**
     * Prints to screen all the attributes of the collection.
     */
    @Override
    public void execute() {
        LocalDateTime date = collectionManager.getCreationDate();
        System.out.println("COLLECTION INFO:\n"
                + "creation time: " + date.getHour() + ":" + (date.getMinute() > 9 ? date.getMinute() : "0" + date.getMinute())
                + "\ntype of storage: " + collectionManager.getType() + "\nnumber of elements: " + collectionManager.stack().size() + "\n");
    }
}
