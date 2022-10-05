package com.example.board.service;

import com.example.board.domain.Board;
import com.example.board.dto.BoardDto;
import com.example.board.dto.BoardNoPwdDto;
import com.example.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    // 전체 조회
    @Transactional
    public List<Board> showAllBoard(){
        return boardRepository.findAllByOrderByCreatedAtDesc();
//        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, ("createdAt")));

    }

    // 하나만 조회
    @Transactional
    public Board showOneBoard(Long id){
        Board board = boardRepository.findById(id).get();
        return board;
    }

    // 개사물 저장
    @Transactional
    public Board saveBoard(BoardDto boardDto){
        Board board = new Board(boardDto);
        return boardRepository.save(board);
    }


    // 비밀번호 확인
    @Transactional
    public boolean checkPassword(Long id, BoardDto boardDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        return boardDto.getPassword().equals(board.getPassword());
    }



    // 게시글 삭제
    @Transactional
    public Long deleteOneBoard(Long id){
        boardRepository.deleteById(id);
        return id;
    }

    // 게시물 수정
    @Transactional
    public Long updateBoard(Long id, BoardDto boardDto){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        board.update(boardDto);
        return board.getId();

    }


}
