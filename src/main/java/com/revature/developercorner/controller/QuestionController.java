package com.revature.developercorner.controller;

import com.revature.developercorner.dto.QuestionDto;
import com.revature.developercorner.dto.UserDto;
import com.revature.developercorner.entity.Question;
import com.revature.developercorner.entity.User;
import com.revature.developercorner.service.QuestionService;
import com.revature.developercorner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @PostMapping("/addquestion")
    public QuestionDto addquestion(@RequestBody QuestionDto questionDto) {
        System.out.println(questionDto);
        Question question = new Question();
        question.setUser_id(questionDto.getUser_id());
        question.setLanguage(questionDto.getLanguage());
        question.setQuestion(questionDto.getQuestion());
        if (questionDto.getCreated_at() != null)
            question.setCreated_at(new Timestamp(questionDto.getCreated_at().getTime()));

        if (questionDto.getUpdated_at() != null)
            question.setUpdated_at(new Timestamp(questionDto.getUpdated_at().getTime()));

        question = questionService.addQuestion(question);

        questionDto.setId(question.getUser_id());
        questionDto.setError_or_success("SUCCESS");
        System.out.println(question);

        return questionDto;
    }

    @PostMapping("/updatequestion")
    public QuestionDto updateQuestion(@RequestBody QuestionDto questionDto) {
        System.out.println(questionDto);
        Question question = new Question();
        question.setId(questionDto.getId());
        question.setUser_id(questionDto.getUser_id());
        question.setLanguage(questionDto.getLanguage());
        question.setQuestion(questionDto.getQuestion());
        if (questionDto.getCreated_at() != null)
            question.setCreated_at(new Timestamp(questionDto.getCreated_at().getTime()));

        if (questionDto.getUpdated_at() != null)
            question.setUpdated_at(new Timestamp(questionDto.getUpdated_at().getTime()));
        questionService.updateQuestion(question, question.getUser_id());

        System.out.println(question);
        questionDto.setError_or_success("SUCCESS");
        return questionDto;
    }

    @PostMapping("/deletequestion")
    public QuestionDto deleteQuestion(@RequestBody QuestionDto questionDto) {
        System.out.println(questionDto);
        questionService.delete(questionDto.getId());
        questionDto.setError_or_success("SUCCESS");
        return questionDto;

    }

    @GetMapping("/listquestions")
    public List listquestions(@RequestBody QuestionDto questionDto) {
        List<Question> questions = questionService.getAll();
        List questionDtolist = new ArrayList();

        if (questions != null) {
            questions.forEach(question -> {
                QuestionDto questionDto1 = new QuestionDto();
                questionDto1.setId(question.getId());
                questionDto1.setUser_id(question.getUser_id());
                questionDto1.setQuestion(question.getQuestion());
                questionDto1.setLanguage(question.getLanguage());
                questionDto1.setCreated_at(question.getCreated_at());
                questionDto1.setUpdated_at(question.getUpdated_at());

                questionDtolist.add(questionDto1);
            });
        }
        return questionDtolist;
    }
}
