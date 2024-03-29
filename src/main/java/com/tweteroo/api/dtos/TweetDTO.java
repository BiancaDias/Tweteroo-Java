package com.tweteroo.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TweetDTO {


  @NotBlank
  @Size(max = 280, message = "Maximun length for text is 280 characters!")
  private String tweet;

  @NotNull
  private Long userId;
}
