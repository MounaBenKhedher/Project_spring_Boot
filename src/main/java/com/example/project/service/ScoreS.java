package com.example.project.service;

import com.example.project.dto.Scoredto;
import com.example.project.exception.MissingEntity;
import com.example.project.model.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ScoreS {
    double calculateScore(String values);
    Score addScore(Scoredto scoreDto);
    Score getScoreById(long id) throws MissingEntity;

    Score updateScore(Long id, Score updatedScore);
    public Map<String,Boolean> deleteScore(long id) throws MissingEntity;
    public Score saveScore(Score score);
    public List<DATE> getAllSVDates();

    public List<ENUMERATION> getAllVEnums();

    public List<INTERVALE> getAllSVIntervals();

    public List<NUMBER> getAllVNumbers();
    Optional<Score> findById(Long id);
}
