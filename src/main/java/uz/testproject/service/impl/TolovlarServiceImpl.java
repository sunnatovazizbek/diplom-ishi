package uz.testproject.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.testproject.entity.SudlanganlikHaqidaMalumot;
import uz.testproject.entity.Tolovlar;
import uz.testproject.entity.User;
import uz.testproject.model.Result;
import uz.testproject.payload.TolovlarPayload;
import uz.testproject.repository.SudlanganlikHaqidaRepository;
import uz.testproject.repository.TolovlarRepository;
import uz.testproject.repository.UserRepository;
import uz.testproject.service.TolovlarService;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TolovlarServiceImpl implements TolovlarService {

    private final TolovlarRepository tolovlarRepository;
    private final SudlanganlikHaqidaRepository sudlanganlikHaqidaRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<?> saveTolovlar(TolovlarPayload payload) {
        try {
            Tolovlar tolovlar = new Tolovlar();
            SudlanganlikHaqidaMalumot sudlanganlikHaqidaMalumot=sudlanganlikHaqidaRepository.findById(payload.getSudlanganlikHaqidaMalumotId()).get();
            User user = userRepository.findByUsername(payload.getUserName());
            tolovlar.setPrice(payload.getPrice());
            tolovlar.setSudlanganlikHaqidaMalumot(sudlanganlikHaqidaMalumot);
            tolovlar = tolovlarRepository.save(tolovlar);
            tolovlar.setUser(user);
            if (tolovlar != null) {
                return ResponseEntity.ok(Result.ok(tolovlar));
            }
            return new ResponseEntity(new Result(false, "error save payment", null), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("error payment(tolovlar)", e.getMessage());
            return new ResponseEntity(new Result(false, "error save payment", null), HttpStatus.CONFLICT);
        }
    }

    @Override
    public ResponseEntity<?> editTolovlar(TolovlarPayload payload) {
        try {
            Tolovlar tolovlar = new Tolovlar();
            tolovlar = tolovlarRepository.findById(payload.getId()).get();
            tolovlar.setPrice(payload.getPrice());
            tolovlar = tolovlarRepository.save(tolovlar);
            if (tolovlar != null) {
                return ResponseEntity.ok(Result.ok(tolovlar));
            }
            return new ResponseEntity(new Result(false, "edit save payment", null), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("error edit payment(tolovlar)", e.getMessage());
            return new ResponseEntity(new Result(false, "edit save payment", null), HttpStatus.CONFLICT);
        }
    }

    @Override
    public ResponseEntity<?> getAllTolovlar() {
        try {
            List<Tolovlar> tolovlarList = tolovlarRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
            return ResponseEntity.ok(Result.ok(tolovlarList));
        } catch (Exception e) {
            log.error("error payment", e.getMessage());
            return new ResponseEntity(new Result(false, "error getAll payment", null), HttpStatus.CONFLICT);
        }
    }

    @Override
    public ResponseEntity<?> getTolovlarUserId(Long userId) {
        try {
            List<Tolovlar> tolovlarListUserId = tolovlarRepository.findByUserId(userId);
            return ResponseEntity.ok(Result.ok(tolovlarListUserId));
        } catch (Exception e) {
            log.error("error payment(tolovlar)", e.getMessage());
            return new ResponseEntity(new Result(false, "error tolovlarListUserId payment", null), HttpStatus.CONFLICT);
        }
    }

    @Override
    public ResponseEntity<?> deleteTolovlarId(Long tolovId) {
        try {
            tolovlarRepository.deleteById(tolovId);
            return ResponseEntity.ok(Result.ok("delete succesfull"));
        } catch (Exception e) {
            log.error("delete error payment(tolovlar)", e.getMessage());
            return new ResponseEntity(new Result(false, "error delete payment", null), HttpStatus.CONFLICT);
        }
    }

}
