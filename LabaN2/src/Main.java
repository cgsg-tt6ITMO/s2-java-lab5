/* This file was written by myself
 * It's purpose is to store main function.
 * */

import ru.ifmo.se.pokemon.*;
import pokemons.*;

public class Main {
    public static void main(String[] args) {
        Battle b = new Battle();
        Eevee p1 = new Eevee("Чужой", 1);
        Pokemon p2 = new Pokemon("Хищник", 1);
        Mesprit m = new Mesprit("Месси", 45);
        b.addAlly(p1);
        b.addFoe(p2);
        b.addAlly(m);
        b.go();
    }
}
