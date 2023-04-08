package uz.testproject.service;


import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import uz.testproject.payload.NewsPayload;
import uz.testproject.payload.SudlanganlikHaqidaPayload;

public interface SudlanganlikHaqidaService {

    ResponseEntity<?> saveSudlanganlikHaqida(SudlanganlikHaqidaPayload payload);

    ResponseEntity<?> editSudlanganlikHaqidaMalumot(SudlanganlikHaqidaPayload payload);

    ResponseEntity<?> getSudlanganlikHaqidaMalumot(String username);

    ResponseEntity<?> deleteSudlanganlikHaqidaMalumot(Long sudlanganlikHaqidaMalumotId);
}
