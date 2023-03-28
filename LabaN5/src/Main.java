/**
 * @author Troitskaya Tamara (cgsg-tt6)
 */

/*
28.03.2023
Route - rewrite setters (shorter, no try-catch in catch)
переменная окружения (ну или оставить args)
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
