package uz.testproject.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.testproject.entity.AnswerQuestion;
import uz.testproject.entity.Xabarnoma;
import uz.testproject.model.Result;
import uz.testproject.payload.AnswerQuestionPayload;
import uz.testproject.repository.AnswerQuestionRepository;
import uz.testproject.repository.XabarnomaRepository;
import uz.testproject.service.AnswerQuestionService;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AnswerQuestionImpl implements AnswerQuestionService {

    private final AnswerQuestionRepository answerQuestionRepository;
    private final XabarnomaRepository xabarnomaRepository;

    @Override
    public ResponseEntity<?> addAnswerQuestion(AnswerQuestionPayload payload) {
        try {
            AnswerQuestion answerQuestion=new AnswerQuestion();
            Xabarnoma xabarnoma=xabarnomaRepository.findById(payload.getXabarnomaId()).get();
            answerQuestion.setXabarnoma(xabarnoma);
            answerQuestion.setAnswer(payload.getAnswer());
            answerQuestion=answerQuestionRepository.save(answerQuestion);
            if (answerQuestion != null) {
                return ResponseEntity.ok(new Result(true, "created answerQuestion succesfull", answerQuestion));
            } else {
                return ResponseEntity.ok(new Result(false, "answerQuestion error in save", null));
            }
        } catch (Exception e) {
            log.error("add answerQuestion error -> {}", e.getMessage());
            return ResponseEntity.ok(new Result(false, "answerQuestion error in save", null));
        }
    }


    @Override
    public ResponseEntity<?> editAnswerQuestion(AnswerQuestionPayload payload) {
        try {
            AnswerQuestion answerQuestion=answerQuestionRepository.findById(payload.getId()).get();
            Xabarnoma xabarnoma=xabarnomaRepository.findById(payload.getXabarnomaId()).get();
            answerQuestion.setXabarnoma(xabarnoma);
            answerQuestion.setAnswer(payload.getAnswer());
            answerQuestion=answerQuestionRepository.save(answerQuestion);
            if (answerQuestion != null) {
                return ResponseEntity.ok(new Result(true, "created answerQuestion succesfull", answerQuestion));
            } else {
                return ResponseEntity.ok(new Result(false, "answerQuestion error in save", null));
            }
        } catch (Exception e) {
            log.error("edit answerQuestion error -> {}", e.getMessage());
            return ResponseEntity.ok(new Result(false, "answerQuestion error in edit", null));
        }
    }

    @Override
    public ResponseEntity<?> getAnswerQuestion(String username){
        try {
            List<AnswerQuestionPayload> answerQuestionPayloads=answerQuestionRepository.getByUsernameAnswerQuestion(username);
            if (answerQuestionPayloads != null) {
                return ResponseEntity.ok(new Result(true, "answerQuestionPayloads succesfull", answerQuestionPayloads));
            } else {
                return ResponseEntity.ok(new Result(false, "answerQuestionPayloads false", null));
            }
        }catch (Exception e){
            log.error("answerQuestionPayloads error -> {}", e.getMessage());
            return ResponseEntity.ok(new Result(false, "answerQuestionPayloads false", null));
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            answerQuestionRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error("delete news");
            return false;
        }
    }


}
