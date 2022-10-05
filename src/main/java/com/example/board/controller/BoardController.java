package com.example.board.controller;

import com.example.board.domain.Board;
import com.example.board.dto.BoardDto;
import com.example.board.dto.BoardNoPwdDto;
import com.example.board.repository.BoardRepository;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository boardRepository;
    private final BoardService boardService;

    // 전체 게시글 조회
    @GetMapping("/api/post")
    public List<Board> getAllBoard(){
      return boardService.showAllBoard();
    }

    // 하나 게시물 조회
    @GetMapping("/api/post/{id}")
    public Board getOneBoard(@PathVariable Long id){
        return boardService.showOneBoard(id);
    }

    // 게시글 작성
    @PostMapping("/api/post")
    public Board createBoard(@RequestBody BoardDto boardDto){
//        Board board = new Board(boardDto);
//        return boardRepository.save(board);
        return boardService.saveBoard(boardDto);

    }

    // 게시글 비밀번호 확인
    @PostMapping("/api/post/{id}")
    public boolean checkPwd(@PathVariable Long id, @RequestBody BoardDto boardDto){
            return  boardService.checkPassword(id, boardDto);
    }

    // 게시글 삭제
    @DeleteMapping("/api/post/{id}")
    public Long delete(@PathVariable Long id){
        return boardService.deleteOneBoard(id);

    }

    // 게시물 수정
    @PutMapping("/api/post/{id}")
    public Long update(@PathVariable Long id, @RequestBody BoardDto boardDto){
        return boardService.updateBoard(id, boardDto);
    }
}