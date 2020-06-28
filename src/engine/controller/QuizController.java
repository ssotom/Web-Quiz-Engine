package engine.controller;

import engine.model.quiz.Feedback;
import engine.model.quiz.Quiz;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("api/quiz")
public class QuizController {

    @GetMapping
    public Quiz get() {
        Quiz quiz = new Quiz();
        List<String> options = List.of("Robot","Tea leaf","Cup of coffee","Bug");
        quiz.setTitle("The Java Logo");
        quiz.setText("What is depicted on the Java logo?");
        quiz.setOptions(options);

        return quiz;
    }

    @PostMapping
    public Feedback solveQuiz(@RequestParam int answer) {
        Feedback feedback = new Feedback();

        if (answer == 2) {
            feedback.setSuccess(true);
            feedback.setFeedback("Congratulations, you're right!");
        } else {
            feedback.setSuccess(false);
            feedback.setFeedback("Wrong answer! Please, try again.");
        }

        return feedback;
    }
}
