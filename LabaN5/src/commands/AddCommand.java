/**
 * @author Troitskaya Tamara (cgsg-tt6)
 */
package commands;

import management.CollectionManager;
import management.Input;

/**
 * Handle 'add' method.
 */
public class AddCommand extends AbstractCommand implements Command {
    private CollectionManager collectionManager;
    private Input inputManager;

    /**
     * Set name and description for 'add' command.
     */
    public AddCommand(CollectionManager storage, Input inputManager) {
        super("add", "adds your element to the collection;");
        this.collectionManager = storage;
        this.inputManager = inputManager;
    }

    /**
     * Adds one element from console to the collection.
     */
    @Override
    public void execute() {
        System.out.println("ADD ELEMENT:");
        collectionManager.stack().add(inputManager.inpRoute());
        System.out.println("NEW ELEMENT ADDED SUCCESSFULLY\n");
    }
}
