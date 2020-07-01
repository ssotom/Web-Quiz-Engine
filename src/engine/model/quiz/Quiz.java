package engine.model.quiz;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Quiz {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    private String title;

    @NotBlank
    private String text;


    @Size(min = 2)
    @NotNull
    @ElementCollection
    private List<String> options;


    @ElementCollection
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Integer> answer = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String>options) {
        this.options = options;
    }

    public Set<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(Set<Integer> answer) {
        this.answer = answer;
    }

    public Feedback solve(Answer answer) {
        Feedback feedback = new Feedback();
        Set<Integer> answerSet = answer.getAnswer();

        if (this.answer.equals(answerSet)) {
            feedback.setSuccess(true);
            feedback.setFeedback("Congratulations, you're right!");
        } else {
            feedback.setSuccess(false);
            feedback.setFeedback("Wrong answer! Please, try again.");
        }

        return feedback;
    }

}
