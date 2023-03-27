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
    private static Stack<Route> stack = new Stack<>();
    private final String type;
    private final java.time.LocalDateTime creationDate;
    private static Long lastId = 0L;
    // for 'execute_script'
    private ArrayList<String> files = new ArrayList<>();

    /**
     * @return array of paths with scripts we met on our way.
     */
    public ArrayList<String> getFiles() {
        return files;
    }

    /**
     * Adds a path to array of scripts we used for our work.
     * @param path a path to the script and it's name.
     */
    public void fadd(String path) {
        this.files.add(path);
    }

    /**
     * Makes the array of scripts we met empty.
     * Purpose: if we call one script second time while running the program,
     *     it would throw InfiniteLoopException though it should not.
     */
    public void fclear() {
        this.files.clear();
    }

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

    public CollectionManager(String file) {
        type = "Stack";
        creationDate = LocalDateTime.now();
        // initialization:
        DefaultInputCommand defaultInp = new DefaultInputCommand(file, this);
        defaultInp.execute();
    }

}
