package dev.v4jp.cebooklub.controller;

import dev.v4jp.cebooklub.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BookController {

  private final BookService bookService;

  @GetMapping("/books")
  public ModelAndView list() {
    ModelAndView mv = new ModelAndView("books/list");
    mv.addObject("books", bookService.readBooks());
    return mv;
  }
}
