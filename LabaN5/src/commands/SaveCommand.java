/**
 * @author Troitskaya Tamara (cgsg-tt6)
 */
package commands;

import management.CollectionManager;
import management.JSONManager;

/**
 * Handle 'save' method.
 */
public class SaveCommand extends AbstractCommand implements Command {
    private final String path;
    private final CollectionManager collectionManager;
    private final JSONManager jsonManager;

    /**
     * Set name and description for 'save' command.
     */
    public SaveCommand(String path, CollectionManager collectionManager, JSONManager js) {
        super("save", "saves collection to json file.;");
        this.path = path;
        this.collectionManager = collectionManager;
        this.jsonManager = js;
    }

    /**
     * Save collection to json file.
     */
    @Override
    public void execute() {
        jsonManager.write(collectionManager.stack(), path);
        System.out.println("SAVED TO JSON SUCCESSFULLY");
    }
}
