package guru.springframework.springwebapp.domain;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity


public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title ;
    private String                                              isbn ;
    @ManyToOne
    private guru.springframework.springwebapp.domain.Publisher publisher;

    @ManyToMany
    @JoinTable(name = "author_book" , joinColumns = @JoinColumn(name = "book_id") , inverseJoinColumns =
    @JoinColumn(name = "author_id"))
    private Set< guru.springframework.springwebapp.domain.Author > authors = new HashSet <> ();


    public Book ( ) {

    }

    public Book ( String title , String isbn ) {
        this.title = title;
        this.isbn  = isbn;
    }


    public guru.springframework.springwebapp.domain.Publisher getPublisher ( ) {
        return publisher;
    }

    public void setPublisher ( guru.springframework.springwebapp.domain.Publisher publisher ) {
        this.publisher = publisher;
    }

    public Set < guru.springframework.springwebapp.domain.Author > getAuthors ( ) {
        return authors;
    }

    public void setAuthors ( Set < guru.springframework.springwebapp.domain.Author > authors ) {
        this.authors = authors;
    }

    public long getId ( ) {
        return id;
    }

    public void setId ( long id ) {
        this.id = id;
    }

    public String getTitle ( ) {
        return title;
    }

    public void setTitle ( String title ) {
        this.title = title;
    }

    public String getIsbn ( ) {
        return isbn;
    }

    public void setIsbn ( String isbn ) {
        this.isbn = isbn;
    }

    @Override
    public String toString ( ) {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", authors=" + authors +
                '}';
    }

    @Override
    public boolean equals ( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass () != o.getClass () ) return false;

        Book book = ( Book ) o;

        return id == book.id;
    }

    @Override
    public int hashCode ( ) {
        return ( int ) ( id ^ ( id >>> 32 ) );
    }
}
