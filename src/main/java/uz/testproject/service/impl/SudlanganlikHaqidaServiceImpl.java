package uz.testproject.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.testproject.entity.Qarorlar;
import uz.testproject.entity.SudlanganlikHaqidaMalumot;
import uz.testproject.entity.User;
import uz.testproject.model.Result;
import uz.testproject.payload.SudlanganlikHaqidaPayload;
import uz.testproject.repository.QarorlarRepository;
import uz.testproject.repository.SudlanganlikHaqidaRepository;
import uz.testproject.repository.UserRepository;
import uz.testproject.service.SudlanganlikHaqidaService;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SudlanganlikHaqidaServiceImpl implements SudlanganlikHaqidaService {

    private final SudlanganlikHaqidaRepository sudlanganlikHaqidaRepository;
    private final QarorlarRepository qarorlarRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<?> saveSudlanganlikHaqida(SudlanganlikHaqidaPayload payload) {
        try {
            SudlanganlikHaqidaMalumot sudlanganlikHaqidaMalumot=new SudlanganlikHaqidaMalumot();
            sudlanganlikHaqidaMalumot.setRegion(payload.getRegion());
            sudlanganlikHaqidaMalumot.setDate(payload.getDate());
            Qarorlar qarorlar=qarorlarRepository.findById(payload.getQarorId()).get();
            sudlanganlikHaqidaMalumot.setQarorlar(qarorlar);
            User user=userRepository.findByUsername(payload.getUserName());
            sudlanganlikHaqidaMalumot.setUser(user);
            sudlanganlikHaqidaMalumot=sudlanganlikHaqidaRepository.save(sudlanganlikHaqidaMalumot);
            if (sudlanganlikHaqidaMalumot != null) {
                return ResponseEntity.ok(new Result(true, "save sudlanganlikHaqidaMalumot succesfull", sudlanganlikHaqidaMalumot));
            }
            return ResponseEntity.ok(new Result(false, "sudlanganlikHaqidaMalumot error in save", null));
        } catch (Exception e) {
            log.error("save sudlanganlikHaqidaMalumot error", e.getMessage());
            return ResponseEntity.ok(new Result(false, "sudlanganlikHaqidaMalumot error in save", null));
        }
    }

    @Override
    public ResponseEntity<?> editSudlanganlikHaqidaMalumot(SudlanganlikHaqidaPayload payload) {
        try {
            SudlanganlikHaqidaMalumot sudlanganlikHaqidaMalumot=sudlanganlikHaqidaRepository.findById(payload.getId()).get();
            sudlanganlikHaqidaMalumot.setRegion(payload.getRegion());
            sudlanganlikHaqidaMalumot.setDate(payload.getDate());
            Qarorlar qarorlar=qarorlarRepository.findById(payload.getQarorId()).get();
            sudlanganlikHaqidaMalumot.setQarorlar(qarorlar);
            User user=userRepository.findByUsername(payload.getUserName());
            sudlanganlikHaqidaMalumot.setUser(user);
            sudlanganlikHaqidaMalumot=sudlanganlikHaqidaRepository.save(sudlanganlikHaqidaMalumot);
            if (sudlanganlikHaqidaMalumot != null) {
                return ResponseEntity.ok(new Result(true, "edit sudlanganlikHaqidaMalumot succesfull", sudlanganlikHaqidaMalumot));
            }
            return ResponseEntity.ok(new Result(false, "sudlanganlikHaqidaMalumot error in edit", null));
        } catch (Exception e) {
            log.error("edit sudlanganlikHaqidaMalumot error", e.getMessage());
            return ResponseEntity.ok(new Result(false, "sudlanganlikHaqidaMalumot error in edit", null));
        }
    }

    @Override
    public ResponseEntity<?> getSudlanganlikHaqidaMalumot(String username) {
        try {
            List<SudlanganlikHaqidaMalumot> sudlanganlikHaqidaMalumots = sudlanganlikHaqidaRepository.findByUserUsername(username);
            return ResponseEntity.ok(new Result(true, "get sudlanganlikHaqidaMalumot", sudlanganlikHaqidaMalumots));
        } catch (Exception e) {
            log.error("error sudlanganlikHaqidaMalumot", e.getMessage());
            return ResponseEntity.ok(new Result(false, "error sudlanganlikHaqidaMalumot", null));
        }
    }

    @Override
    public ResponseEntity<?> deleteSudlanganlikHaqidaMalumot(Long sudlanganlikHaqidaMalumotId) {
        try {
            sudlanganlikHaqidaRepository.deleteById(sudlanganlikHaqidaMalumotId);
            return ResponseEntity.ok(Result.ok("delete sudlanganlikHaqidaMalumotId succesfull"));
        } catch (Exception e) {
            log.error("delete sudlanganlikHaqidaMalumotId", e.getMessage());
            return new ResponseEntity(new Result(false, "error delete sudlanganlikHaqidaMalumotId", null), HttpStatus.CONFLICT);
        }
    }

}
