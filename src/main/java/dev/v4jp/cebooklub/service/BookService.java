package dev.v4jp.cebooklub.service;

import dev.v4jp.cebooklub.mapper.BookMapper;
import dev.v4jp.cebooklub.model.Book;
import dev.v4jp.cebooklub.util.ImageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {

    private final BookMapper bookMapper;

    @Value("${cloudfront.url}")
    private String cloudfrontUrl;

    public List<Book> readBooks() {
        List<Book> books = bookMapper.selectBooks();

        for (Book b : books) {
            if (StringUtils.isEmpty(b.getDominantColor())) {
                try {
                    String dominantColor = ImageUtils.getDominantColor(cloudfrontUrl + b.getImagePath());
                    bookMapper.updateDominantColor(b.getId(), dominantColor);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return books;
    }
}
