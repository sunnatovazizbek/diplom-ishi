package uz.testproject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.testproject.payload.AnswerQuestionPayload;
import uz.testproject.service.AnswerQuestionService;
import uz.testproject.service.XabarnomaService;

@RestController
@RequestMapping("/api/answerquestion")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class AnswerQuestionController {

    private final AnswerQuestionService answerQuestionService;

    @PostMapping("/save")
    public ResponseEntity<?> saveanswerQuestion(@RequestBody AnswerQuestionPayload payload){
        return answerQuestionService.addAnswerQuestion(payload);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editanswerQuestion(@RequestBody AnswerQuestionPayload payload){
        return answerQuestionService.editAnswerQuestion(payload);
    }

    @DeleteMapping("/{answerQuestionId}")
    public boolean deleteNewsId(@PathVariable("answerQuestionId") Long id){
        return answerQuestionService.deleteById(id);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<?> getAnswerQuestionUserName(@PathVariable("userName") String username){
        return answerQuestionService.getAnswerQuestion(username);
    }




}
