package com.book.check.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
public class AdminReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String month;
    
    @Column(nullable = false)
    private String week;
    
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;
    
    @Column
    private String fileName;
    
    @Column
    private String filePath;

    
}
