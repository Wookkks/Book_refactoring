package com.book.check.dto;

import org.springframework.web.multipart.MultipartFile;

public class AdminReviewDto {

    private int id;
    private String img;
    private String month;
    private String week;
    private String title;
    private String content;

    private MultipartFile[] multipartFiles = new MultipartFile[1];
}
