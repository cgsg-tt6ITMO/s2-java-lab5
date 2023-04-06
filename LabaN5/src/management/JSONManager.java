/**
 * @author Troitskaya Tamara (cgsg-tt6)
 */
package management;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import task.Coordinates;
import task.Location;
import task.Route;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

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
            String negus = mapper.writeValueAsString(storage);
            output.write(negus);
            output.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Дефолтное чтение. Пока работает только при 1 элементе в коллекции
     */
    public Stack<Route> read(String path) {
        Stack<Route> myObjects = new Stack<>();
        //String input = "{\"id\":1,\"name\":\"xxx\",\"coordinates\":{\"x\":42.0,\"y\":53.0},\"from\":{\"x\":1.0,\"y\":2.0,\"z\":3,\"name\":\"prra\"},\"to\":{\"x\":423.0,\"y\":423.0,\"z\":42,\"name\":\"hope\"},\"distance\":597.3658845297412}";
        try {
            FileReader input = new FileReader(path);
            Scanner sc = new Scanner(input);
            //myObjects = mapper.readValue(input, new TypeReference<Stack<Route>>(){});
            //*
            //while (sc.hasNext()) {
                // convert JSON file to map
                Map<?, ?> map = mapper.readValue(input, Map.class);

                String name = (String) map.get("name");
                Map<String, String> coords = (Map<String, String>) map.get("coordinates");
                Coordinates coordinates = new Coordinates(Double.parseDouble(String.valueOf(coords.get("x"))), Float.parseFloat(String.valueOf(coords.get("y"))));
                //System.out.println(coordinates.getX() + " " + coordinates.getY());
                Map<String, String> locfrom = (Map<String, String>) map.get("from");
                Location from = new Location(
                        Float.parseFloat(String.valueOf(locfrom.get("x"))),
                        Float.parseFloat(String.valueOf(locfrom.get("y"))),
                        Long.parseLong(String.valueOf(locfrom.get("z"))),
                        String.valueOf(locfrom.get("name")));
                Map<String, String> locto = (Map<String, String>) map.get("from");
                Location to = new Location(
                        Float.parseFloat(String.valueOf(locto.get("x"))),
                        Float.parseFloat(String.valueOf(locto.get("y"))),
                        Long.parseLong(String.valueOf(locto.get("z"))),
                        String.valueOf(locto.get("name")));
                Route route = new Route(name, coordinates, from, to);
                myObjects.add(route);
            //}

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return myObjects;
    }
}
