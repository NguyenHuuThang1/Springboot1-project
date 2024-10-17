package com.bookStore.controller;

import com.bookStore.entity.Book;
import com.bookStore.entity.MyBookList;
import com.bookStore.service.BookService;
import com.bookStore.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private MyBookListService myBookListService;

    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/book_register")
    public String bookRegister(){
        return "bookRegister";
    }
    @GetMapping("/available_book")
    public ModelAndView getAllBook(){
        List<Book>list = bookService.getAllBook();
//        ModelAndView m = new ModelAndView();
//        m.setView("bookList");
//        m.addObject("book",list);
        return new ModelAndView("bookList","book",list);
    }
    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b){
        bookService.save(b);
        return "redirect:/available_book";
    }
    @GetMapping("/my_books")
    public String getMyBooks(Model model){
        List<MyBookList> list = myBookListService.getAllMyBookList();
        model.addAttribute("book",list);
        return "myBooks";
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id){
        Book b = bookService.getBookById(id);
        MyBookList mb = new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
        myBookListService.saveMyBook(mb);
        return "redirect:/my_books";
    }
    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        Book b = bookService.getBookById(id);
        model.addAttribute("book",b);
        return "bookEdit";
    }
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id){
        bookService.deleteBookById(id);
        return "redirect:/available_book";
    }
}
