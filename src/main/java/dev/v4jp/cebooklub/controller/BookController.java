package dev.v4jp.cebooklub.controller;

import dev.v4jp.cebooklub.model.Book;
import dev.v4jp.cebooklub.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BookController {

    @Value("${cloudfront.url}")
    private String cloudfrontUrl;

    private final BookService bookService;

    @GetMapping("/cebooklub-rewind")
    public String list(Model model) {
        List<Book> books = bookService.readBooks();

        model.addAttribute("books", books);
        model.addAttribute("prefix", cloudfrontUrl);

        return "list";
    }

    @GetMapping(path = "/")
    String emptyPath() {
        return "redirect:/cebooklub-rewind";
    }
}
