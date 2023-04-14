package uz.testproject.service;

import org.springframework.http.ResponseEntity;
import uz.testproject.payload.AnswerQuestionPayload;
import uz.testproject.payload.XabarnomaPayload;

public interface AnswerQuestionService {
    ResponseEntity<?> addAnswerQuestion(AnswerQuestionPayload payload);

    ResponseEntity<?> editAnswerQuestion(AnswerQuestionPayload payload);

    ResponseEntity<?> getAnswerQuestion(String username);

    boolean deleteById(Long id);
}
