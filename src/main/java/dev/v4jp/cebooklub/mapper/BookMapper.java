package dev.v4jp.cebooklub.mapper;

import dev.v4jp.cebooklub.model.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {
  List<Book> selectBooks();

  void updateDominantColor(
          @Param("id") long id,
          @Param("dominantColor") String dominantColor);
}
