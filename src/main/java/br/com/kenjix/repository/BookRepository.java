package br.com.kenjix.repository;

import br.com.kenjix.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {}