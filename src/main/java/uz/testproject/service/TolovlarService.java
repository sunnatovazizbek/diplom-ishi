package uz.testproject.service;


import org.springframework.http.ResponseEntity;
import uz.testproject.entity.Tolovlar;
import uz.testproject.payload.SudlanganlikHaqidaPayload;
import uz.testproject.payload.TolovlarPayload;

public interface TolovlarService {

    ResponseEntity<?> saveTolovlar(TolovlarPayload payload);


    ResponseEntity<?> editTolovlar(TolovlarPayload payload);


    ResponseEntity<?> getAllTolovlar();

    ResponseEntity<?> getTolovlarUserId(String userId);

    ResponseEntity<?> deleteTolovlarId(Long tolovId);

}
