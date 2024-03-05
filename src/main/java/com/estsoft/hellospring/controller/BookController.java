package com.estsoft.hellospring.controller;

import com.estsoft.hellospring.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
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

    @PostMapping("/books")
    public String saveBook(@RequestParam("id") String id,
                           @RequestParam("name") String name,
                           @RequestParam("author") String author) {

        bookRepository.saveBook(new BookDTO(id, name, author));
        try {

        } catch(Exception e) {
            log.error("");
        }
        return "redirect:/books";
    }

    // GET /books/{id} @PathVariable 어노테이션 형태로 받을 수 있음
    @GetMapping("/books/{id}")
    public String detail(@PathVariable("id") String isbn, Model model) {
        log.info("isbn = " + isbn);

        // TODO 화면에 보여줄 book 객체를 model에 넣어주기(id, name, author)
        BookDTO book = bookRepository.getBook(isbn);
        model.addAttribute("book", book);

        return "bookDetail";
    }
}
