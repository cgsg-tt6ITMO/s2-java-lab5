/**
 * @author Troitskaya Tamara (cgsg-tt6)
 */

/*
 * 25.03.2023:
 * @TODO
 *   execute script:
 *      не надо писать предложения ввести данные - когда весь код будет написан, loop скопировать в execute_script и в Client.run()
 *      создать массив имён задействованных файлов, и если имя встречается снова, сказать что бесконечный цикл
 *   написать в readme что всегда вводить все элементы на разных строках и написать что в defaultcollection первое число - кол-во эл-тов
 *      и написать там границы чисел для ввода (hashcode in Route: может получиться очень большое число)
 *   переписать javadoc на один язык и в одном стиле
 *   ещё между прочим у меня по тз в Location стало меньше полей
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
