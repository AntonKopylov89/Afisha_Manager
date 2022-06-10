package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class FilmRepository {

    private int filmLimit = 10;

    public FilmRepository(int filmLimit) {
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

    public FilmName[] findById(int id) {
        FilmName[] tmp = new FilmName[1];
        int index = 0;
        for (FilmName film : films) {
            if (film.getId() == id) {
                tmp[index] = film;
                index++;
            }
        }
        films = tmp;
        return films;
    }

    public void removeById(int id) {
        int length = films.length - 1;
        FilmName[] tmp = new FilmName[length];
        int index = 0;
        for (FilmName film : films) {
            if (film.getId() != id) {
                tmp[index] = film;
                index++;
            }
        }
        films = tmp;
    }

    public void removeAll() {
        FilmName[] tmp = new FilmName[films.length];
        films = tmp;
    }


}
