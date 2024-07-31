package dev.v4jp.cebooklub.service

import dev.v4jp.cebooklub.mapper.BookMapper
import dev.v4jp.cebooklub.model.Book
import spock.lang.Specification
import spock.lang.Subject

import java.time.LocalDate
import java.time.Month

class BookServiceTest extends Specification {

  def bookMapper = Mock(BookMapper)

  @Subject
  BookService bookService = new BookService(bookMapper)

  def "Get all books for year 2023"(){
    given:
    bookMapper.selectBooks() >> List.of(Book.builder()
    .id(1)
    .title("The Bell Jar")
    .author("Sylvia Plath")
    .body("Loren ipsum and what about it!")
    .date_read(LocalDate.of(2023, Month.APRIL,28))
    .build())

    when:
    List<Book> result = bookService.readBooks()

    then:
    result.size() == 1
  }
}
