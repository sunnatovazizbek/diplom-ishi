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
                return new ResponseEntity(new Result(false, "error qarorlar save", null), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            log.error("add qarorlar error -> {}", e.getMessage());
            return new ResponseEntity(new Result(false, "error qarorlar save", null), HttpStatus.INTERNAL_SERVER_ERROR);
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
                return new ResponseEntity(new Result(false, "error edit qarorlar", null), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            log.error("edit qarorlar error -> {}", e.getMessage());
            return new ResponseEntity(new Result(false, "edit qarorlar error", null), HttpStatus.BAD_REQUEST);
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
