package uz.testproject.service;

import org.springframework.http.ResponseEntity;
import uz.testproject.payload.NewSudSanasiPayload;
import uz.testproject.payload.XabarnomaPayload;

public interface XabarnomaService {
    ResponseEntity<?> addXabarnoma(XabarnomaPayload payload);

    ResponseEntity<?> editXabarnoma(XabarnomaPayload payload);

    ResponseEntity<?> getXabarnomaUsername(String username);

    boolean deleteById(Long id);
}
