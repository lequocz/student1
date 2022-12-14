package com.example.demo2.service;

import com.example.demo2.model.Score;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

public interface ScoreService {
    ResponseEntity getAll();
    ResponseEntity createScore( int id);
    ResponseEntity findScore( int id);
    ResponseEntity updateScore(Score score);
}
