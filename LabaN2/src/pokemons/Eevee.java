package pokemons;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

import attacks.DoubleTeam;
import attacks.TailWhip;
import attacks.Confide;

public class Eevee extends Pokemon {
    public Eevee() {
        super("DefaultEevee", 5);
        this.setType(Type.NORMAL);
        this.setStats(55,55,50,45,65,55);
        // moves
        this.addMove(new DoubleTeam());
        this.addMove(new TailWhip());
        this.addMove(new Confide());
    }
    public Eevee(String name, int level) {
        super(name, level);
        this.setType(Type.NORMAL);
        this.setStats(55,55,50,45,65,55);
        // moves
        this.addMove(new DoubleTeam());
        this.addMove(new TailWhip());
        this.addMove(new Confide());
    }
}
