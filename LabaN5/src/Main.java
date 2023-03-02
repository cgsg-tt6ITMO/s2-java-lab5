// unnecessary in case of using class Client
import task.*;
import commands.*;
import task.Location;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Troitskaya Tamara (TT6)
 * @TODO new gradle project...
 * Переместить все функции взаимодействия с коллекцией в StackStorage
 * либо как-то хранить instance stack в каждой функции...
 */

/**
 * var: 81476
 * 368924
 */
public class Main {

    /**
     * Entry point.
     * кстати лучше не юзать конструкторы.
     * @param args - arguments from cmd.
     */
    public static void main(String [] args) {
        Client client = new Client();
        client.run();
        // run почему-то вылетает при консольном вводе, хотя я полагала он будет работать пока пользователь не введёт exit
        /*
        StackStorage storage = new StackStorage();
        Stack<Route> stack = storage.stack();
        Add.addFromFile(stack, "defaultcollection.txt");
        Show.show(stack);

        Route r1 = new Route("Route number one", new Coordinates(1.0,(float)1.07), new Location(), new Location());//new Location((float)18.0, 12.12345, 50, "Loc1"), new Location());
        Route r2 = new Route("Route number two", new Coordinates(1.0,(float)1.0), new Location((float)1.0, (float)2.0, 5, "Loc2"), new Location());
        stack.add(r1);
        stack.add(r2);
        // по идее при попытке добавить элемент с существующим Id, должно вылетать исключение
        // incorrect. при клиентском вводе такой ситуации не возникнет - все параметры каждый раз надо будет заново вводить
        stack.add(r1);
        Route r3 = new Route("Route number one", new Coordinates(1.0,(float)1.07), new Location((float)18.0, (float)12.12345, 50, "Loc1"), new Location());
        stack.add(r3);
        Help.help();

/**
help
add
faf4
5.1 3.14
18.0 22.05 50 loc1
1.0 2.01 5 loc2
add
faf5
5.1 3.14
18.0 22.05 50 loc1
1.0 2.0 5 loc2
save
info
exit/
        Info.info(storage);
        Save.save("out.txt", stack);
        Show.show(stack);
        //Clear.clear(stack);
        stack.clear();
        Show.show(stack);
        */
    }
}
