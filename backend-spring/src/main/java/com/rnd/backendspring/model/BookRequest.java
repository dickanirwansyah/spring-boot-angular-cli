package com.rnd.backendspring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {

    private String id;

    @NotBlank(message = "title book cannot be null")
    private String titleBook;

    @NotBlank(message = "author book cannot be null")
    private String authorBook;

    @Min(value = 1, message = "available book minimum 1 and cannot be zero")
    private int availableBook;

}
