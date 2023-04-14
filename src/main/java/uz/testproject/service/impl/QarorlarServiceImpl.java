package uz.testproject.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.testproject.entity.Qarorlar;
import uz.testproject.model.Result;
import uz.testproject.payload.QarorlarPayload;
import uz.testproject.repository.QarorlarRepository;
import uz.testproject.service.QarorlarService;

@Service
@Slf4j
@RequiredArgsConstructor
public class QarorlarServiceImpl implements QarorlarService {

    private final QarorlarRepository qarorlarRepository;

    @Override
    public ResponseEntity<?> addQarorlar(QarorlarPayload payload) {
        try {
            Qarorlar qarorlar=new Qarorlar();
            qarorlar.setTitle(payload.getTitle());
            qarorlar.setBody(payload.getBody());
            qarorlar=qarorlarRepository.save(qarorlar);
            if (qarorlar != null) {
                return ResponseEntity.ok(new Result(true, "created qarorlar succesfull", null));
            } else {
                return ResponseEntity.ok(new Result(false, "Qarorlar error in save", null));
            }
        } catch (Exception e) {
            log.error("add qarorlar error -> {}", e.getMessage());
            return ResponseEntity.ok(new Result(false, "Qarorlar error in save", null));
        }
    }

    @Override
    public ResponseEntity<?> editQarorlar(QarorlarPayload payload) {
        try {
            Qarorlar qarorlar=qarorlarRepository.findById(payload.getId()).get();
            qarorlar.setTitle(payload.getTitle());
            qarorlar.setBody(payload.getBody());
            qarorlar=qarorlarRepository.save(qarorlar);
            if (qarorlar != null) {
                return ResponseEntity.ok(new Result(true, "edit qarorlar succesfull", null));
            } else {
                return ResponseEntity.ok(new Result(false, "Qarorlar error in edit", null));
            }
        } catch (Exception e) {
            log.error("edit qarorlar error -> {}", e.getMessage());
            return ResponseEntity.ok(new Result(false, "Qarorlar error in edit", null));
        }
    }


    @Override
    public boolean deleteById(Long id) {
        try {
            qarorlarRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error("delete qarorId");
            return false;
        }
    }




}
