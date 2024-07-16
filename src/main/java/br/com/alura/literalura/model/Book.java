package br.com.alura.literalura.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.alura.literalura.dto.BookDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int downloadCount;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    public Book() {

    }

    public Book(BookDTO bookDTO) {
        this.title = bookDTO.title();
        this.downloadCount = bookDTO.downloadCount();
        this.authors = bookDTO.authors().stream()
                .map(authorDTO -> new Author(authorDTO.name(), authorDTO.birthYear(), authorDTO.deathYear()))
                .collect(Collectors.toSet());

    }

    public String getTitle() {
        return title;
    }

}
