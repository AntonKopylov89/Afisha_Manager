package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AfishaManagerTest {
    FilmName first = new FilmName("Джентельмены", 15);
    FilmName second = new FilmName("Начало", 28);
    FilmName third = new FilmName("Бладшот", 110);
    FilmName fourth = new FilmName("Вперед", 201);
    FilmName fifth = new FilmName("Отель 'Белград'", 140);
    FilmName sixth = new FilmName("Человек - невидимка", 25);
    FilmName seventh = new FilmName("Тролли.Мировой тур", 81);
    FilmName eighth = new FilmName("Номер один", 73);
    FilmName ninth = new FilmName("Мстители", 96);
    FilmName tenth = new FilmName("Не время умирать", 156);
    FilmName eleventh = new FilmName("Интерстеллар", 177);

    FilmRepository repo = new FilmRepository();
    AfishaManager manager = new AfishaManager(repo);


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
    public void shouldFindFilmById(){

        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.save(sixth);

        FilmName[] actual = manager.findById(110);
        FilmName[] expected = { third };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveFilmById(){

        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.save(sixth);

        manager.removeById(15);

        FilmName[] actual = manager.findAll();
        FilmName[] expected = { second, third, fourth,fifth, sixth };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAllFilms(){

        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.save(sixth);

        manager.removeAll();

        FilmName[] actual = manager.findAll();
        FilmName[] expected = { null, null, null, null, null, null };

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

        FilmRepository repo = new FilmRepository(11);
        AfishaManager manager = new AfishaManager(repo);

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

        FilmName[] expected = { eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first };
        FilmName[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShow5Films(){

        FilmRepository repo = new FilmRepository(5);
        AfishaManager manager = new AfishaManager(repo);

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

        FilmName[] expected = { eleventh, tenth, ninth, eighth, seventh};
        FilmName[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
