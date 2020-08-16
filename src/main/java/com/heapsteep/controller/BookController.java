package com.heapsteep.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.heapsteep.model.Book;
import com.heapsteep.model.BookDetail;
import com.heapsteep.repository.BookRepository;

@RestController
@RequestMapping("/api")
public class BookController {
	@Autowired
    BookRepository bookRepository;
	
	@Autowired
	private Environment environment;

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping("/saveBooks")
    public Book saveBooks(@Validated @RequestBody Book book) {
        return bookRepository.save(book);
    }
    
    @GetMapping("/getBookDetail/{id}")
    public BookDetail getBookDetail(@PathVariable Long id) {
        Book book= bookRepository.getOne(id);
        BookDetail bookDetail=new BookDetail();
        bookDetail.setBookTitle(book.getBookTitle());
        bookDetail.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return bookDetail;
    }
   
}