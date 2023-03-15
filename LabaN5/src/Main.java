/**
 * @author Troitskaya Tamara (TT6)
 */

/*
 * 10.03.2023:
 * @TODO
 *   написать тесты
 *   input as json
 *   : this command doesn't exist yet. - исправить
 *   шаблон проектирования Builder - так как вообще-то лучше не юзать конструкторы.
 *   command pattern
 *   переписать javadoc на один язык и в одном стиле
 *   new gradle project...
 *   писать где-нить что по одному элементу на строку вводить
 *   как сравнивать элементы?
 *   надо будет сделать исключения, связанные с файлами
 *   и исключение, связанное с тем, что скрипт потом сам себя вызывает и получается бесконечный цикл
 *   выход: можно считать глубину, типо кол-во раз, сколько вызывается execute_script или кол-во
 *     команд, после которого программа выдаёт что-то типо хватит уже.
 *   execute script:
 *      не надо писать предложения ввести данные - когда весь код будет написан, loop скопировать в execute_script и в Client.run()
 *   hashcode in Route: может получиться очень большое число. Нужно установить границы
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
        client.run();
    }
}
