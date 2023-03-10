/**
 * @author Troitskaya Tamara (TT6)
 * 10.03.2023:
 * @TODO
 * delete by id
 * execute script
 * add element from file
 * save as json
 * шаблон проектирования Builder - так как вообще-то лучше не юзать конструкторы.
 * при возникновении exception нужно попросить пользователя ввести другие данные
 * переписать javadoc на один язык и в одном стиле
 * new gradle project...
 */

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
        client.run();
    }
}
