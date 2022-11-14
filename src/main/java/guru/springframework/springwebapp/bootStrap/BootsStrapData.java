package guru.springframework.springwebapp.bootStrap;

import guru.springframework.springwebapp.domain.Author;
import guru.springframework.springwebapp.domain.Book;
import guru.springframework.springwebapp.domain.Publisher;
import guru.springframework.springwebapp.repository.AuthorRepository;
import guru.springframework.springwebapp.repository.BookRepository;
import guru.springframework.springwebapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootsStrapData implements CommandLineRunner {


    private  final  AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootsStrapData ( AuthorRepository authorRepository , BookRepository bookRepository , PublisherRepository publisherRepository ) {
        this.authorRepository = authorRepository;
        this.bookRepository   = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run ( String... args ) throws Exception {




//creating author
        Author nanna = new Author ( "nanna " , "dash" );
//creating book
        Book nannaBook = new Book ("SpringBoot ", "12347878");
//creating publisher
        Publisher publisher = new Publisher (  );
//        fFor publisher
        publisher.setCity ( "bbsr" );
        publisher.setName ( "n-PUBLISH" );
        publisher.setState ( "ODISHA" );
        publisher.setZip ( "12312" );
        publisherRepository.save ( publisher );
//        fFor publisher


//adding book to author
        nanna.getBooks ().add ( nannaBook );

//        |||||||||||||||||   adding publisher and author to book ||||||||||||||||||||||||||
//        adding author to book
        nannaBook.getAuthors ().add ( nanna );

        //        adding publisher to book
        nannaBook.setPublisher ( publisher );
//        |||||||||||||||||   adding publisher and author to book ||||||||||||||||||||||||||


        //        adding book to publisher
        publisher.getBooks ().add ( nannaBook );


//saving the author

        authorRepository.save ( nanna );

//        saving book
        bookRepository.save ( nannaBook );


//        another author
                        Author rod  = new Author ("rod", "johnson");
//                        another  book 2
                        Book ejb = new Book ( "J2EE", "67868234" );
//                        adding the book2 to author
                        rod.getBooks ().add ( ejb );
//                        adding the author to book2
                        ejb.getAuthors ().add ( rod );
//                        adding publisher to book 2
        ejb.setPublisher (  publisher);
//        adding book to publisher
        publisher.getBooks ().add ( ejb );

//        savingthem all
                        authorRepository.save ( rod );
                        bookRepository.save ( ejb );
                        publisherRepository.save ( publisher );
        System.out.println ("Starting bootStrap  ...... ");
        System.out.println ( "number Of books  :  :: " +bookRepository.count ());

        System.out.println ("no of books  by publisher "+publisher.getBooks ().size ());
    }
}
