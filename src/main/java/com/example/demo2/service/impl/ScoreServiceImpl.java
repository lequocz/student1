package com.example.demo2.service.impl;

import com.example.demo2.model.Score;
import com.example.demo2.repository.ScoreRepository;
import com.example.demo2.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    ScoreRepository scoreRepository;
    @Override
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(scoreRepository.findAll(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity createScore(int id) {
        for (Score score0:
        scoreRepository.findAll()) {
            if(score0.getId() == id){
                return new ResponseEntity<>("da ton tai", HttpStatus.OK);
            }
        }
        Score score = new Score();
        score.setId(id);
        score.setSubject_id(1);
        scoreRepository.save(score);

        Score score1 = new Score();
        score1.setId(id);
        score1.setSubject_id(2);
        scoreRepository.save(score1);

        Score score2 = new Score();
        score2.setId(id);
        score2.setSubject_id(3);
        scoreRepository.save(score2);

        Score score3 = new Score();
        score3.setId(id);
        score3.setSubject_id(4);
        scoreRepository.save(score3);

        return new ResponseEntity<>("tao thanh cong", HttpStatus.OK);
    }

    @Override
    public ResponseEntity findScore(int id) {
        return new ResponseEntity<>(scoreRepository.findById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity updateScore(Score score) {
        scoreRepository.save(score);
        return new ResponseEntity(score, HttpStatus.OK);
    }

}


