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


//        fFor publisher
        Author nanna = new Author ( "nanna " , "dash" );
        Book nannaBook = new Book ("SpringBoot ", "12347878");
        Publisher publisher = new Publisher (  );
        publisher.setCity ( "bbsr" );
        publisher.setName ( "n-PUBLISH" );
        publisher.setState ( "ODISHA" );
        publisher.setZip ( "12312" );
        publisherRepository.save ( publisher );




        nanna.getBooks ().add ( nannaBook );
        nannaBook.getAuthors ().add ( nanna );
        nannaBook.setPublisher ( publisher );
        publisher.getBooks ().add ( nannaBook );




        authorRepository.save ( nanna );
        bookRepository.save ( nannaBook );

                        Author rod  = new Author ("rod", "johnson");
                        Book ejb = new Book ( "J2EE", "67868234" );
                        rod.getBooks ().add ( ejb );
                        ejb.getAuthors ().add ( rod );
        ejb.setPublisher (  publisher);
        publisher.getBooks ().add ( ejb );

                        authorRepository.save ( rod );
                        bookRepository.save ( ejb );
                        publisherRepository.save ( publisher );
        System.out.println ("Starting bootStrap  ...... ");
        System.out.println ( "number Of books  :  :: " +bookRepository.count ());

        System.out.println ("no of books  by publisher "+publisher.getBooks ().size ());
    }
}
