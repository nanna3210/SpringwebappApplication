package guru.springframework.springwebapp.controller;

import guru.springframework.springwebapp.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

//    dependency
    private final BookRepository bookRepository;


    public BookController ( BookRepository bookRepository ) {
        this.bookRepository = bookRepository;
    }


    @RequestMapping("/books")
    public String getBooks( Model model ){

        model.addAttribute ( bookRepository.findAll () );

        return "books";
    }
}
