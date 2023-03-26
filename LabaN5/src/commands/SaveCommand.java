/**
 * @author Troitskaya Tamara (cgsg-tt6)
 */
package commands;

import management.CollectionManager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Handle 'save' method.
 */
public class SaveCommand extends AbstractCommand implements Command {
    private String path;
    private CollectionManager collectionManager;

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
        var stack = collectionManager.stack();
        System.out.println("SAVE COLLECTION:\nСохранение производится в файл " + path + "\n");
        try {
            BufferedWriter output = new BufferedWriter(new FileWriter(path));

            output.write("\"MyStack\": [\n");
            for (var el : stack) {
                output.write("\t\"Route\" : {\n"
                        + "\t\t\"id\": " + el.getId() + ", \n"
                        + "\t\t\"name\": \"" + el.getName() + "\", \n"
                        + "\t\t\"creationDate\": \"" + el.getCreationDate()
                        + "\",\n\t\t\"coordinates\": {\n\t\t\t\"x\": " + el.getCoordinates().getX() + ",\n\t\t\t\"y\": " + el.getCoordinates().getY()
                        + "\n\t\t},\n\t\t\"to\": {\n\t\t\t\"name\": \"" + el.getTo().getName() + "\",\n\t\t\t\"x\": " + el.getTo().getX() + ",\n\t\t\t\"y\": " + el.getTo().getY() + ",\n\t\t\t\"z\": " + el.getTo().getZ()
                        + "\n\t\t},\n\t\t\"from\": {\n\t\t\t\"name\": \"" + el.getFrom().getName() + "\",\n\t\t\t\"x\": " + el.getFrom().getX() + ",\n\t\t\t\"y\": " + el.getFrom().getY() + ",\n\t\t\t\"z\": " + el.getFrom().getZ()
                        + "\n\t\t},\n\t\t\"distance\": " + el.getDistance() + "\n"
                        + "\t},\n");
            }
            output.write("]\n");
            output.close();
        }
        catch (IOException e) {
            System.err.println("Exception while output: " + e.getMessage());
        }
    }
}
