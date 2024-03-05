package com.estsoft.hellospring.controller;

import com.estsoft.hellospring.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookController {
    //todo GET : /books
    //controller -> service -> repository 호출의 필요성은 아직 안느껴져 repository 바로 호출해보기
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public String home(Model model) {
        List<BookDTO> bookList = bookRepository.getAllBooks();
        model.addAttribute("bookList", bookList); // addAttribute 시 네이밍 일치하지 않으면 안되니 주의!
        // 더이상 List.of(bookList) 필요 x
        return "bookManager";
    }



}
