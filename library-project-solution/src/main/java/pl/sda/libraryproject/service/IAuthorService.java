package pl.sda.libraryproject.service;

import pl.sda.libraryproject.model.Author;

import java.util.List;

public interface IAuthorService {
    List<Author> findAll();
}
