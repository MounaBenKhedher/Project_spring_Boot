package com.example.project.service;
/*
import com.example.project.dto.Notationdto;
import com.example.project.model.*;
import com.example.project.repository.NotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
/*
@Service
public class Notationservice {

    @Autowired
    NotationRepository notationRepository;

    public Notationdto createNotation(Notationdto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("DTO cannot be null");
        }

        Notation notation = new Notation();
        notation.setDescription(dto.getDescription());

        // Map score type and values
        Score score = createScore(dto);
        notation.setScoreType(Notation.ScoreType.valueOf(dto.getScoreType()));
        notation.setScoreValue(score);

        // Save the notation to the repository
        Notation savedNotation = notationRepository.save(notation);

        // Return the saved notation as DTO
        return Notationdto.of(savedNotation);
    }

    private Score createScore(Notationdto dto) {
        Score score;

        switch (dto.getScoreType()) {
            case "NUMBER":
                score = new NUMBER();
                ((NUMBER) score).setValeur(dto.getNumberValue());
                break;
            case "ENUMERATION":
                score = new ENUMERATION();
                ((ENUMERATION) score).setValeur(dto.getEnumerationValue());
                break;
            case "INTERVALE":
                score = new INTERVALE();
                ((INTERVALE) score).setvMin(dto.getIntervalMin());
                ((INTERVALE) score).setvMax(dto.getIntervalMax());
                break;
            case "DATE":
                score = new DATE();
                ((DATE) score).setValeur(dto.getDateValue());
                break;
            default:
                throw new IllegalArgumentException("Unhandled ScoreType: " + dto.getScoreType());
        }

        return score;
    }

    public Notationdto getNotationById(Long id) {
        Optional<Notation> notationOptional = notationRepository.findById(id);
        if (notationOptional.isPresent()) {
            return Notationdto.of(notationOptional.get());
        } else {
            throw new IllegalArgumentException("Notation not found with id: " + id);
        }
    }

}*/