package uz.testproject.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AnswerQuestionPayload {

    private Long id;

    private String answer;

    private String question;

    private Long xabarnomaId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date createQuestion;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date createAnswer;

    public AnswerQuestionPayload(Long id, String answer, String question, Date createQuestion, Date createAnswer) {
        this.id = id;
        this.answer = answer;
        this.question = question;
        this.createQuestion = createQuestion;
        this.createAnswer = createAnswer;
    }
}
