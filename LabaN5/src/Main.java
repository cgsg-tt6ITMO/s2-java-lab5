/**
 * @author Troitskaya Tamara (cgsg-tt6)
 */

import management.Client;

/**
 * var: 81476
 * 368924
 */
public class Main {

    /**
     * Entry point.
     * @param args - arguments from cmd.
     */
    public static void main(String [] args) {
        Client client = new Client();
        client.run("out.json");
    }
}
