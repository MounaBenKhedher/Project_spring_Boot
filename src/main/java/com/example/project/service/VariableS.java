package com.example.project.service;

import com.example.project.dto.Scoredto;
import com.example.project.dto.Variabledto;
import com.example.project.exception.MissingEntity;
import com.example.project.model.Model;
import com.example.project.model.Score;
import com.example.project.model.Variable;

import java.util.List;
import java.util.Optional;

public interface VariableS {
    List<Variable> getAllVariable();

    Variable getVariableById(long id) throws MissingEntity;


    Variable updateVariable(Long id, Variable updatedVariable);

    Variable save(Variable variable);

    public Variable findById(long id) throws MissingEntity;

    // double calculateScore(List<String> values);
    public void addScoreToVariable(long variableId, Score score);
    public Variable createVariable(Variable variable, long modelId);
    Variable findByIdVariable(Long id);
    public Optional<Variable> getVariableWithScores(Long id);
    public List<Scoredto> getScoresByVariableId(Long variableId);
    void deleteVariable(Long id);
    double calculatePonderationForVariable(Long variableId);

}


