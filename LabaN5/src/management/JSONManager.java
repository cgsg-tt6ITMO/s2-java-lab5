/**
 * @author Troitskaya Tamara (cgsg-tt6)
 */
package management;

import com.fasterxml.jackson.databind.ObjectMapper;

import task.Route;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

/**
 * Handles work with json files.
 */
public class JSONManager {
    private final ObjectMapper mapper = new ObjectMapper();

    public JSONManager() {}

    /**
     * Save collection to file
     * @param storage stack of elements to save
     * @param path file where to save
     */
    public void write(Stack<Route> storage, String path) {
        try {
            BufferedWriter output = new BufferedWriter(new FileWriter(path));
            String negus = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(storage);
            output.write(negus);
            output.close();
        } catch (IOException e) {
            System.err.println("json, write to file:" + e.getMessage());
        }
    }

    /**
     * Read values from JSON file.
     */
    public Stack<Route> read(String path) {
        Stack<Route> st = new Stack<>();
        try {
            List<Route> books = Arrays.asList(mapper.readValue(Paths.get(path).toFile(), Route[].class));

            for (Route route : books) {
                st.add(route);
            }

        } catch (Exception ex) {
            System.err.println("default input from json file:" + ex.getMessage());
            ex.printStackTrace();
        }
        return  st;
    }
}
