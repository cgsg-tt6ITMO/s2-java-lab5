/**
 * @author Troitskaya Tamara (cgsg-tt6)
 */
package management;

import task.Coordinates;
import task.Location;
import task.Route;

import java.util.Scanner;

/**
 * Purpose: make similar Input managers, one of which asks the client to input and the another one doesn't.
 */
public interface Input {
    void setScanner(Scanner sc);

    Route inpRoute();

    Coordinates inpCoordinates(String name);
    Location inpLocation(String name);
    Double inpDouble(String name);
    Float inpFloat(String name);
    Long inpLong(String name);
    String inpString(String name);

}
