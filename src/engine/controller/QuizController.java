package engine.controller;

import engine.model.quiz.Answer;
import engine.model.quiz.Feedback;
import engine.model.quiz.Quiz;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("api/quizzes")
public class QuizController {

    List<Quiz> quizzes = new ArrayList<>();

    @GetMapping
    public List<Quiz> getAll() {
        return quizzes;
    }

    @GetMapping("/{id}")
    public Quiz getById(@PathVariable int id) {
        if (id <= quizzes.size()) {
            return quizzes.get(id - 1);
        }
        throw new QuizNotFoundException(id);
    }

    @PostMapping
    public Quiz create(@Valid @RequestBody Quiz quiz) {
        quiz.setId(quizzes.size() + 1);
        quizzes.add(quiz);

        return quiz;
    }

    @PostMapping("/{id}/solve")
    public Feedback solve(@PathVariable int id, @RequestBody Answer answer) {
        return quizzes.get(id - 1).solve(answer);
    }

}

@ResponseStatus(HttpStatus.NOT_FOUND)
class QuizNotFoundException extends RuntimeException {

    public QuizNotFoundException(int id) {
        super("Could not find a quiz with id: " + id);
    }

}
