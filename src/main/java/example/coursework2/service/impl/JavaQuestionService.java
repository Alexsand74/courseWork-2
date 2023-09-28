package example.coursework2.service.impl;

import example.coursework2.exception.QuestionAlreadyExistsException;
import example.coursework2.exception.QuestionNotFoundException;
import example.coursework2.model.Question;
import example.coursework2.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions;
    private final Random random;

    public JavaQuestionService() {
        this.questions = new HashSet<>();
        this.random = new Random();
    }

    @Override
    public Question add(String qestion, String ansver) {
        return add(new Question(qestion, ansver));
    }

    @Override
    public Question add(Question question) {
        if (!questions.add(question)) {
            throw new QuestionAlreadyExistsException();
        }
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.remove(question))
            throw new QuestionNotFoundException();
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        // return questions;
        return new HashSet<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
        int numberOfMembersInTheSetQuestions = questions.size();             // узнаем размер Set questions

        int randomNumber = random.nextInt(numberOfMembersInTheSetQuestions); // в пределах размера questions
           // выбираем любое число от нуля до размера данной коллекции Set используя метод nextInt от random

        List<Question> questionList = new ArrayList<>(questions); // создаем новый ArrayList и переводим все
        // элементы с коллекции Set questions в ArrayList questionList, для того что бы получить индексированную
        // коллекцию.

        return questionList.get(randomNumber);
    }   // здесь, методом get возвращаем элемент сгенерированного Question используя индекс

}
