package uz.testproject.service;


import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import uz.testproject.payload.NewsPayload;
import uz.testproject.payload.QarorlarPayload;

public interface QarorlarService {

    ResponseEntity<?> addQarorlar(QarorlarPayload payload);

    ResponseEntity<?> editQarorlar(QarorlarPayload payload);

    boolean deleteById(Long id);
}
