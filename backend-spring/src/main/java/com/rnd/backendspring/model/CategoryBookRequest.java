package com.rnd.backendspring.model;

import com.rnd.backendspring.config.util.validator.CategoryNameMustUnique;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryBookRequest implements Serializable {

    private String id;

    @NotBlank(message = "category name cannot be null")
    @CategoryNameMustUnique(message = "category name must unique")
    private String nameCategory;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
