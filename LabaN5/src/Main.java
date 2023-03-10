/**
 * @author Troitskaya Tamara (TT6)
 */

/*
 * 10.03.2023:
 * @TODO
 *   execute script
 *   add element from file
 *   save as json
 *   шаблон проектирования Builder - так как вообще-то лучше не юзать конструкторы.
 *   Нужно handle InputMismatchException или NumberFormatException - вывести ошибку и повторить ввод.
        * пока что обрабатывается только если число не в том диапазоне, а если строку вместо числа ввести - нет
 *   переписать javadoc на один язык и в одном стиле
 *   new gradle project...
 *   packages изменить, поудалять лишние файлы из корня проекта
 *   писать где-нить что по одному элементу на строку вводить
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
