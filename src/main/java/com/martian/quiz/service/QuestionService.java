package com.martian.quiz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.martian.quiz.dao.QuestionRepository;
import com.martian.quiz.model.Question;

@Service
public class QuestionService {
	
	@Autowired
	QuestionRepository questionRepo;
	
	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
			return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK);
			//respnseEntity has both response and the status code
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
		//if there is an error, we will return an empty list with the status of Bad request
	}

	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		try {
			return new ResponseEntity<>(questionRepo.findByCategory(category), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestion(Question question) {
		try {
			questionRepo.save(question);
			return new ResponseEntity<>("Success", HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Fail", HttpStatus.UNPROCESSABLE_ENTITY);
		
	}

	public ResponseEntity<String> deleteQuestion(Integer id) {
		try {
			questionRepo.deleteById(id);;
			return new ResponseEntity<>("Success", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Failed to delete", HttpStatus.NOT_FOUND);
	}
	
}
