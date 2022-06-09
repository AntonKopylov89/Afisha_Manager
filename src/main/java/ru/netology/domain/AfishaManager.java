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

    private FilmName[] films = new FilmName[0];

    public void save(FilmName newFilm) {
        int length = films.length + 1;
        FilmName[] tmp = new FilmName[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = newFilm;
        films = tmp;
    }

    public FilmName[] findAll() {
        return films;
    }

    public FilmName[] findLast() {
        FilmName[] items = findAll();
        int resultLength;
        if (filmLimit > items.length) {
            resultLength = items.length;
        } else {
            resultLength = filmLimit;
        }
        FilmName[] result = new FilmName[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

}
