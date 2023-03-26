/**
 * @author Troitskaya Tamara (cgsg-tt6)
 */
package management;

import task.Coordinates;
import task.Location;
import task.Route;

import java.util.Scanner;

public interface Input {
    void setScanner(Scanner sc);

    Route inpRoute();

    Coordinates inpCoordinates(String name);
    Location inpLocation(String name);
    Double inpDouble(String name);
    Long inpLong(String name);
    String inpString(String name);

}
