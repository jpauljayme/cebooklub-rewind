package dev.v4jp.cebooklub.service;

import dev.v4jp.cebooklub.mapper.BookMapper;
import dev.v4jp.cebooklub.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService{

  private final BookMapper bookMapper;

  public List<Book> readBooks() {
    return bookMapper.selectBooks();
  }
}
