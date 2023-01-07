package com.CodeWallah.LibraryDB;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add_book")
    public void addBook(@RequestBody() Book book){
        try {
            bookService.createBookService(book);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/update_pages")
    public void updatePages(@RequestBody() UpdateBookPages updateBookPages){
        bookService.updateBookPages(updateBookPages);
    }

    @GetMapping("/get_book")
    public Book getBook(@RequestParam("id") Integer id){
        try {
            Book book = bookService.getBookById(id);
            return book;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        return null;
    }

    @GetMapping("/get_book_name_and_authors")
    public List<BookAuthorObject> getBookNameAndAuthors(){
        List<BookAuthorObject> list = bookService.getBookAndAuthor();

        return list;
    }
}
