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

  String imagePath;

  @NotBlank
  LocalDate dateRead;

  LocalDate dateCreated;

  LocalDate dateUpdated;

  String dominantColor;
}
