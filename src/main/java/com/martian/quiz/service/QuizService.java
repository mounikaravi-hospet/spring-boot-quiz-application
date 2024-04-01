package com.martian.quiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.martian.quiz.dao.QuestionRepository;
import com.martian.quiz.dao.QuizRepository;
import com.martian.quiz.model.Question;
import com.martian.quiz.model.QuestionWrapper;
import com.martian.quiz.model.Quiz;
import com.martian.quiz.model.Response;

@Service
public class QuizService {
	
	@Autowired
	QuizRepository quizRepo;
	
	@Autowired
	QuestionRepository questionRepo;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		
		List<Question> questions = questionRepo.findRandomQuestionsByCategory(category, numQ);
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizRepo.save(quiz);
		
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
		
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		Optional<Quiz> quiz = quizRepo.findById(id);
		//Optional is used when there might be a case where null is returned. Basically we are saying that getting data is optional
		List<Question> questionsFromDB = quiz.get().getQuestions();
		
		//We have to manually convert Questions into QuestionWrapper
		List<QuestionWrapper> questionsForUser = new ArrayList<QuestionWrapper>();
		for(Question q : questionsFromDB) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			questionsForUser.add(qw);
		}
		
		return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		Optional<Quiz> quiz = quizRepo.findById(id);
		List<Question> questions = quiz.get().getQuestions();
		//checking each answer
		int right = 0;
		int i = 0;
		for(Response response: responses) {
			if(response.getResponse().equals(questions.get(i).getRightAnswer())) {
				right++;
			}
			i++;
		}
		return new ResponseEntity<>(right, HttpStatus.OK);
	}
}
