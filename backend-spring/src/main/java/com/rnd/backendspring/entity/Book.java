package com.rnd.backendspring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book implements Serializable {

    @Id
    private String id;

    @Column(name = "title_book")
    private String titleBook;

    @Column(name = "author_book")
    private String authorBook;

    @Column(name = "available_book")
    private int availableBook;

    @ManyToOne
    @JoinColumn(name = "category_book_id", nullable = false)
    private CategoryBook categoryBook;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
