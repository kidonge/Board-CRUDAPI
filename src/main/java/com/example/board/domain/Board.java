package com.example.board.domain;

import com.example.board.dto.BoardDto;
import com.example.board.dto.BoardNoPwdDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Board  extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String author;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    public Board(String title, String content, String author, String password) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.password = password;
    }

    public Board(BoardDto boardDto) {
        this.title = boardDto.getTitle();
        this.content = boardDto.getContent();
        this.author = boardDto.getAuthor();
        this.password = boardDto.getPassword();
    }

    public Board(BoardNoPwdDto boardNoPwdDto) {
        this.title = boardNoPwdDto.getTitle();
        this.content = boardNoPwdDto.getContent();
        this.author = boardNoPwdDto.getAuthor();
    }

    public void update(BoardDto boardDto){
        this.title = boardDto.getTitle();
        this.content = boardDto.getContent();
        this.author = boardDto.getAuthor();
        this.password = boardDto.getPassword();
    }
}
