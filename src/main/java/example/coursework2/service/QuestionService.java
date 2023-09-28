package example.coursework2.service;

import example.coursework2.model.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String qestion, String ansver);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
