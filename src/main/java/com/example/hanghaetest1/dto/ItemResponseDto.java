package com.example.hanghaetest1.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
public class ItemResponseDto {
    private Long id;
    private String username;
    private String title;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String content;
    private int price;

    public ItemResponseDto(Long id, String username, String title, String content, int price) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.content = content;
        this.price = price;
    }

    public ItemResponseDto(Long id, String title, String username, int price) {
        this.id = id;
        this.title = title;
        this.username = username;
        this.price = price;
        this.content = null;
    }


}