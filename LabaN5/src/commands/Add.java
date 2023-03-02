package commands;
/**
 * @author Troitskaya Tamara (TT6)
 */

import task.Coordinates;
import task.Location;
import task.Route;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

/**
 * Try to input Route objects from file.
 */
public class Add {

    /* Вопрос: как мы будем изменять саму коллекцию? где мы вообще будем её хранить?
     * Метод ниже просто считывает элементы из консоли. Между прочим, тот же код пойдёт и для считывания из файла.
     * Метод, который я назову add по идее лучше бы изменял уже саму коллекцию.
     */

    private static Route inputFromConsole() {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);;
        System.out.println("Введите название маршрута:");
        String Name = sc.nextLine();
        System.out.println("Введите координаты (double, float):");
        Coordinates coords = new Coordinates(sc.nextDouble(), sc.nextFloat());

        System.out.println("Введите значения координат для Location from и название локации:");
        Location f = new Location(sc.nextFloat(), sc.nextFloat(), sc.nextLong(), sc.nextLine());

        System.out.println("Введите значения координат для Location to и название локации:");
        Location t = new Location(sc.nextFloat(), sc.nextFloat(), sc.nextLong(), sc.nextLine());
        sc.close();
        return new Route(Name, coords, f, t);
    }

    /**
     * Потом эти все функции надо перекинуть в файл
     * @param stack - коллекция, в которую добавляем. При перемещении это пропадёт.
     * @param filename - name of input file. For example, "defaultcollection.txt"
     */
    public static void defaultInputFromFile(Stack<Route> stack, String filename) {
        File file = new File(filename);
        try {
            Scanner sc = new Scanner(file).useLocale(Locale.US);
            // сначала в файле должно быть написано, сколько в нём элементов
            int q = sc.nextInt();
            // это чтобы не считывал энтер между числом исходных Route и именем
            sc.nextLine();
            while (q > 0) {
                // название маршрута
                String Name = sc.nextLine();
                // координаты (double, float)
                Coordinates coords = new Coordinates(Double.parseDouble(sc.next()), Float.parseFloat(sc.next()));
                // значения координат для Location from и название локации
                Location f = new Location(Float.parseFloat(sc.next()), Float.parseFloat(sc.next()), sc.nextLong(), sc.nextLine());
                // значения координат для Location to и название локации:
                Location t = new Location(Float.parseFloat(sc.next()), Float.parseFloat(sc.next()), sc.nextLong(), sc.nextLine());
                stack.add(new Route(Name, coords, f, t));
                q--;
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void addOneElementFromFile(Stack<Route> stack, String filename) {
        File file = new File(filename);
        try {
            String Name = null;
            Coordinates coords = null;
            Location f = null, t = null;
            Scanner sc = new Scanner(file).useLocale(Locale.US);
            // название маршрута
            if (sc.hasNext()) {
                Name = sc.nextLine();
            }
            // координаты (double, float)
            Double x = null;
            float y = Float.parseFloat("0");
            if (sc.hasNext()) {
                x = Double.parseDouble(sc.next());
            }
            if (sc.hasNext()) {
                y = Float.parseFloat(sc.next());
            }
            coords = new Coordinates(x, y);

            // значения координат для Location from и название локации
            if (sc.hasNext()) {
                f = new Location(Float.parseFloat(sc.next()), Float.parseFloat(sc.next()), sc.nextLong(), sc.nextLine());
            }
            if (sc.hasNext()) {
                // значения координат для Location to и название локации:
                t = new Location(Float.parseFloat(sc.next()), Float.parseFloat(sc.next()), sc.nextLong(), sc.nextLine());
            }
            stack.add(new Route(Name, coords, f, t));

            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void add(Stack<Route> stack) {
        Route r = inputFromConsole();
        int id = stack.lastElement().getId();
        //Route r = inputFromFile("inp.txt");
        stack.add(r);
        if ((stack.lastElement().getId() - id) != 1) {
            System.err.println("The element is added to the collection twice");
        }
    }
}
