package com.martian.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.martian.quiz.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>{
	public List<Question> findByCategory(String category);

	@Query(value = "SELECT * FROM question q WHERE q.category=:category ORDER By RAND() LIMIT :numQ", nativeQuery = true)
	public List<Question> findRandomQuestionsByCategory(String category, int numQ);
}
