package com.estsoft.hellospring.repository;

import com.estsoft.hellospring.controller.BookDTO;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookRepository {
    private Map<String, BookDTO> bookMap;

    public BookRepository() {
        bookMap = new HashMap<>();
        BookDTO book1 = new BookDTO("123", "오늘도 기획자가 안된다고 말했다", "개발자");
        BookDTO book2 = new BookDTO("978-89-98139-76-6", "객체지향의 사실과 오해", "조영호");
        bookMap.put(book1.getId(), book1);
        bookMap.put(book2.getId(), book2);
    }

    public List<BookDTO> getAllBooks() {
        List<BookDTO> bookList = new ArrayList<>();
        for(Map.Entry<String, BookDTO> book : bookMap.entrySet()) {
            bookList.add(book.getValue());
        }
        return bookList;
    }

    public BookDTO getBook(String id) {
        return bookMap.getOrDefault(id, new BookDTO());
        // 사실 그냥 get 해도 되지만, id가 없으면 빈 DTO를 가져다주기로
    }

    public void saveBook(BookDTO book) {
        bookMap.put(book.getId(), book);
    }
}
