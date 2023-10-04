package com.book.check.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class AdminReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = true)
    private String img;

    @Column(nullable = false)
    private String month;

    @Column(nullable = false)
    private String week;

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;

}
