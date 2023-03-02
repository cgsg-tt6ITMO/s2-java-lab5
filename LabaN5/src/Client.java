/**
 * @author Troitskaya Tamara (TT6)
 */

import commands.*;
import task.Route;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.exit;

/**
 * This class is going to handle the commands that the client gives.
 */

public class Client {
    boolean isFromFile;
    //private getScanner()
    /**
     * This method is for inputting client's commands and handling them.
     */
    public void run() {
        // try catch только при вводе из файла
        //try {
            // сначала нужен сканер, чтобы считать, хочет ли пользователь ввод из консоли или его комманды записаны в файле
            // хотя походу всегда у него консольный ввод самих команд, а из файла может только элемент коллекции браться
        // хотя есть execute script - это ввод функций из файла. но у меня так не поддерживается что параметры для add в том же файле даны
        // получается execute_script должно просто быть одной из комманд свича
            /*
            // этот кусок для случая, когда все команды написаны в файле
            File f = new File("inp.txt");
            Scanner scanner = new Scanner(f).useLocale(Locale.US);
            */
        // опять забыла, зачем useLocale(...)
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        StackStorage storage = new StackStorage();
        Stack<Route> stack = storage.stack();

        Add.defaultInputFromFile(stack, "defaultcollection.txt");
        storage.show();

        while (scanner.hasNext()) {
            String command = scanner.nextLine();
            switch (command) {
                case "help" -> storage.help();
                case "info" -> storage.info();
                // но есть ещё возможность Clear.clear(stack);
                case "clear" -> {
                    stack.clear();
                    System.out.println("Now the collection is empty.\n");
                }
                case "save" -> {
                    String outputfile = "out.txt";
                    storage.save(outputfile);
                    //Save.save(outputfile, stack);
                }
                // проблема с вводом из консоли: после считывания Route из консоли сканер закрывается
                case "add" -> {
                    System.out.println("From file input only (y/n)");
                    if (scanner.hasNext() && true) {
                        String answer = scanner.nextLine();
                        if (answer.equals("y") && true) {
                            System.out.println("Input the path ");
                            if (scanner.hasNext()) {
                                Add.addOneElementFromFile(stack, scanner.nextLine());
                            }
                            else {
                                System.out.println("Shit we found this kal");
                            }
                        } else if (answer.equals("n")) {
                            Add.add(stack);
                            System.out.println("");
                        } else {
                            System.out.println(answer + " is incorrect answer");
                        }
                    } else {
                        System.out.println("add: scanner doesn't has next");
                    }
                }
                case "exit" -> {
                    exit(0);
                }
                case "show" -> storage.show();
                case "execute_script file_name" -> {
                    System.out.println("Soon...");
                }
                default -> System.out.println(command + ": this command doesn't exist yet.");
            }
            // хочу пофиксить то, что почему-то scanner закрывает моё бесконечное считывание комманд >:/
            // предположение: я нажимаю энтер и сканер думает, что это конец ввода вообще и hasNext = false
            //scanner.nextLine();
        }

        scanner.close();

        //}
        /*
        catch (IOException e) {
            System.err.println(e.getMessage());
        }*/
    }
}
