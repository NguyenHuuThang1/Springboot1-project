package com.bookStore.controller;

import com.bookStore.entity.Book;
import com.bookStore.service.BookService;
import com.bookStore.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyBookListController {
    @Autowired
    private MyBookListService myBookListService;
    @Autowired
    private BookService bookService;

    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyList(@PathVariable("id") int id){
        myBookListService.deleteById(id);
        return "redirect:/my_books";
    }

}
