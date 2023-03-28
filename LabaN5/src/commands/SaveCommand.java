/**
 * @author Troitskaya Tamara (cgsg-tt6)
 */
package commands;

import management.CollectionManager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;

/**
 * Handle 'save' method.
 */
public class SaveCommand extends AbstractCommand implements Command {
    private String path;
    private CollectionManager collectionManager;
    private Gson gson = new Gson();

    /**
     * Set name and description for 'save' command.
     */
    public SaveCommand(String path, CollectionManager collectionManager) {
        super("save", "saves collection to json file.;");
        this.path = path;
        this.collectionManager = collectionManager;
    }

    /**
     * Save collection to json file.
     */
    @Override
    public void execute() {
        Gson gson = new Gson();
        var stack = collectionManager.stack();
        System.out.println("SAVE COLLECTION:\nСохранение производится в файл " + path + "\n");
        try (BufferedWriter output = new BufferedWriter(new FileWriter(path))) {
            output.write(gson.toJson(stack));
            System.out.println("SAVED TO JSON SUCCESSFULLY");
        } catch (IOException exception) {
            System.err.println("save: " + exception.getMessage());
        }
    }
}
