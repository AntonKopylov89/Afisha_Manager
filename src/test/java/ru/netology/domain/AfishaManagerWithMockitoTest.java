package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class AfishaManagerWithMockitoTest {
    private FilmRepository repository = Mockito.mock(FilmRepository.class);
    private AfishaManager manager = new AfishaManager(repository);

    private FilmName first = new FilmName("Джентельмены", 15);
    private FilmName second = new FilmName("Начало", 28);
    private FilmName third = new FilmName("Бладшот", 110);
    private FilmName fourth = new FilmName("Вперед", 201);
    private FilmName fifth = new FilmName("Отель 'Белград'", 140);

    @Test
    public void shouldShowAllFilms() {
        FilmName[] returned = {first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();

        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);

        FilmName[] expected = { first, second, third, fourth, fifth };
        FilmName[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldShow5LastFilms() {
        FilmName[] returned = {first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();
        when(repository.getFilmLimit()).thenReturn(10);

        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);

        FilmName[] expected = { fifth, fourth, third, second, first };
        FilmName[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }
}
