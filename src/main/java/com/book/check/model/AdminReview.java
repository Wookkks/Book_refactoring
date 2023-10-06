package com.book.check.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    
    @Column(nullable = false)
    private String dataName;
    
    @Lob
    private byte[] data;
    
    public AdminReview(String month, String week, String title, String content, String dataName, byte[] data) {
    	this.month = month;
    	this.week = week;
        this.title = title;
        this.content = content;
        this.dataName = dataName;
        this.data = data;
    	
    }
}
