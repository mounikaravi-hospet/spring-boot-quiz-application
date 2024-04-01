package com.martian.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.martian.quiz.model.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer>{

}
