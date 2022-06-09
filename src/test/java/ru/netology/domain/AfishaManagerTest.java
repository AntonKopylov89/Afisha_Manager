package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AfishaManagerTest {
    FilmName first = new FilmName("Джентельмены");
    FilmName second = new FilmName("Начало");
    FilmName third = new FilmName("Бладшот");
    FilmName fourth = new FilmName("Вперед");
    FilmName fifth = new FilmName("Отель 'Белград'");
    FilmName sixth = new FilmName("Человек - невидимка");
    FilmName seventh = new FilmName("Тролли.Мировой тур");
    FilmName eighth = new FilmName("Номер один");
    FilmName ninth = new FilmName("Мстители");
    FilmName tenth = new FilmName("Не время умирать");
    FilmName eleventh = new FilmName("Интерстеллар");

    AfishaManager manager = new AfishaManager();

    @Test
    public void shouldAddFilms(){

        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.save(sixth);

        FilmName[] actual = manager.findAll();
        FilmName[] expected = { first, second, third, fourth,fifth, sixth };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShow6Films(){

        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.save(sixth);

        manager.findAll();


        FilmName[] expected = { sixth, fifth, fourth, third, second, first };
        FilmName[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShow10Films(){

        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.save(sixth);
        manager.save(seventh);
        manager.save(eighth);
        manager.save(ninth);
        manager.save(tenth);
        manager.save(eleventh);

        manager.findAll();

        FilmName[] expected = { eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second };
        FilmName[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }



    @Test
    public void shouldShow11Films(){

        AfishaManager manager2 = new AfishaManager(11);

        manager2.save(first);
        manager2.save(second);
        manager2.save(third);
        manager2.save(fourth);
        manager2.save(fifth);
        manager2.save(sixth);
        manager2.save(seventh);
        manager2.save(eighth);
        manager2.save(ninth);
        manager2.save(tenth);
        manager2.save(eleventh);

        manager2.findAll();

        FilmName[] expected = { eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first };
        FilmName[] actual = manager2.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShow5Films(){

        AfishaManager manager3 = new AfishaManager(5);

        manager3.save(first);
        manager3.save(second);
        manager3.save(third);
        manager3.save(fourth);
        manager3.save(fifth);
        manager3.save(sixth);
        manager3.save(seventh);
        manager3.save(eighth);
        manager3.save(ninth);
        manager3.save(tenth);
        manager3.save(eleventh);

        manager3.findAll();

        FilmName[] expected = { eleventh, tenth, ninth, eighth, seventh};
        FilmName[] actual = manager3.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

}
