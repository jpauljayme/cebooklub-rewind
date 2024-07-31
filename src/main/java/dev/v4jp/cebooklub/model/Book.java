package dev.v4jp.cebooklub.model;

import dev.v4jp.cebooklub.validator.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class Book {
  @Id
  long id;

  @NotBlank
  String title;

  @NotBlank
  String author;

  @NotBlank
  String body;

  String image_path;

  @NotBlank
  LocalDate date_read;

  LocalDate t_date_created;

  LocalDate t_date_updated;
}
