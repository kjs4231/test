package com.example.hanghaetest1.dto;

import lombok.Getter;

@Getter
public class ItemResponseDto {
    private Long id;
    private String username;
    private String title;
    private String content;
    private int price;

    public ItemResponseDto(Long id, String username, String title, String content, int price) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.content = content;
        this.price = price;
    }

}