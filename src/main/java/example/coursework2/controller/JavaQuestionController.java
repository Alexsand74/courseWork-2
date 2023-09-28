package example.coursework2.controller;

import example.coursework2.model.Question;
import example.coursework2.service.QuestionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController (QuestionService questionService){
        this.questionService = questionService;
    }
    @RequestMapping("/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer){
        return  questionService.add(question,answer);
    }
    @RequestMapping("/remove")
    public Question removeQuestion(@RequestParam String question,@RequestParam String answer){
        return  questionService.remove(new Question(question,answer));
    }
    @RequestMapping
    public Collection<Question> getAll(){
        return  questionService.getAll();
    }
}
