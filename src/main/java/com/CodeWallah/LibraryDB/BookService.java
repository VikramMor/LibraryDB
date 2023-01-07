package com.CodeWallah.LibraryDB;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public void createBookService(Book book) throws Exception{

        if(bookRepository.findById(book.getId()).get() != null){
            throw new Exception("Book already exists!!!");
        }
        bookRepository.save(book);
    }

    public void updateBookPages(UpdateBookPages updateBookPages){

        int id = updateBookPages.getId();

        Book bookToBeUpdated = bookRepository.findById(id).get();
        bookToBeUpdated.setPages(updateBookPages.getPages());
        bookRepository.save(bookToBeUpdated);
    }

    public Book getBookById(Integer id) throws Exception{
        Book book = bookRepository.findById(id).get();
        return book;
    }
}
