package dev.v4jp.cebooklub.util;

import dev.v4jp.cebooklub.mapper.BookMapper;
import dev.v4jp.cebooklub.model.Book;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BooksDominantColorLoader implements CommandLineRunner {

    @Value("${cloudfront.url}")
    private String cloudfrontUrl;

    private final BookMapper bookMapper;

    @Override
    public void run(String... args) throws Exception {
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
    }
}
