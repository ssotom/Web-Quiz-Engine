package engine.controller;

import engine.model.quiz.Answer;
import engine.model.quiz.Feedback;
import engine.model.quiz.Quiz;
import engine.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController()
@RequestMapping("api/quizzes")
public class QuizController {

    @Autowired
    QuizRepository repository;

    @GetMapping
    public List<Quiz> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Quiz getById(@PathVariable int id) {
        return  repository.findById(id)
                .orElseThrow(() -> new QuizNotFoundException(id));
    }

    @PostMapping
    public Quiz create(@Valid @RequestBody Quiz quiz) {
        return repository.save(quiz);
    }

    @PostMapping("/{id}/solve")
    public Feedback solve(@PathVariable int id, @RequestBody Answer answer) {
        return  repository.findById(id).map(quiz -> quiz.solve(answer))
                .orElseThrow(() -> new QuizNotFoundException(id));
    }

}

@ResponseStatus(HttpStatus.NOT_FOUND)
class QuizNotFoundException extends RuntimeException {

    public QuizNotFoundException(int id) {
        super("Could not find a quiz with id: " + id);
    }

}
