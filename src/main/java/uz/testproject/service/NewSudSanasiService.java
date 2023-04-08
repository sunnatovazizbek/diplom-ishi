package uz.testproject.service;

import org.springframework.http.ResponseEntity;
import uz.testproject.payload.NewSudSanasiPayload;

public interface NewSudSanasiService {
    ResponseEntity<?> addSudDate(NewSudSanasiPayload payload);

    ResponseEntity<?> editNews(NewSudSanasiPayload payload);

    ResponseEntity<?> getNewDateSanasi(String username);

    boolean deleteById(Long id);
}
