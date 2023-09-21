package com.book.check.domain;

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
public class HowBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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
