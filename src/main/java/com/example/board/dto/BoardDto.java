package com.example.board.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BoardDto {

    private String title;
    private String content;
    private String author;
    private String password;

    public BoardDto(String title, String content, String author, String password) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.password = password;
    }

    public BoardDto(BoardDto boardDto){
        this.title = boardDto.getTitle();
        this.content = boardDto.getContent();
        this.author = boardDto.getAuthor();
        this.password = boardDto.getPassword();
    }
}
