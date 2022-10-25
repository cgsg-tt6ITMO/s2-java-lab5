package pokemons;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

import attacks.Mesprit.*;
public class Mesprit extends Pokemon {
    // дефолтный конструктор
    public Mesprit() {
        // super вызывает конструктор Pokemon, он должен идти первой строчкой конструктора подкласса
        // задаём дефолтное имя и левел
        super("DefaultMespirit", 5);
        // задаём тип покемона
        this.setType(Type.PSYCHIC);
        // задаём базовые характеристики покемона
        // HP, ATTACK, DEFENSE, SPECIAL_ATTACK, SPECIAL_DEFENSE, SPEED
        // https://pokemondb.net/pokedex/mesprit
        this.setStats(80, 105, 105, 105, 105, 80);
        // добавляем атаки
        this.setMove(new DreamEater());
        this.setMove(new Thunderbolt());
        this.setMove(new ShadowBall());
        this.setMove(new ThunderWave());
        // как использовать атаку во время боя?
    }
    // конструктор от двух параметров
    public Mesprit(String name, int level) {
        // super вызывает конструктор Pokemon, он должен идти первой строчкой конструктора подкласса
        // задаём дефолтное имя и левел
        super(name, level);
        // тип
        this.setType(Type.PSYCHIC);
        // базовые характеристики
        this.setStats(80, 105, 105, 105, 105, 80);
        // добавляем атаки
        this.setMove(new DreamEater());
        this.setMove(new Thunderbolt());
        this.setMove(new ShadowBall());
        this.setMove(new ThunderWave());
    }
}
