package dev.v4jp.cebooklub.service;

import dev.v4jp.cebooklub.mapper.BookMapper;
import dev.v4jp.cebooklub.model.Book;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {

    private final BookMapper bookMapper;

    public List<Book> readBooks() {

        return bookMapper.selectBooksOrderByDateRead();
    }
}
