package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data

public class AfishaManager {

    private int filmLimit = 10;

    public AfishaManager(int filmLimit) {
        this.filmLimit = filmLimit;
    }
    private FilmRepository repository;

    public AfishaManager(FilmRepository repository) {
        this.repository = repository;
    }

    public void save(FilmName film) {
        repository.save(film);
    }

    public void removeAll() {
        repository.removeAll();
    }

    public FilmName[] findAll() {
       FilmName[] film = repository.findAll();
       return film;
    }

    public FilmName[] findById(int id) {
        FilmName[] film = repository.findById(id);
        return film;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public FilmName[] findLast() {
        FilmName[] items = repository.findAll();
        int resultLength;
        if (repository.getFilmLimit() > items.length) {
            resultLength = items.length;
        } else {
            resultLength = repository.getFilmLimit();
        }
        FilmName[] result = new FilmName[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

}
