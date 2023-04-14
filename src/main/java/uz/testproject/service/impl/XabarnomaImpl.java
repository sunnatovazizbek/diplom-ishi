package uz.testproject.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.testproject.entity.User;
import uz.testproject.entity.Xabarnoma;
import uz.testproject.model.Result;
import uz.testproject.payload.XabarnomaPayload;
import uz.testproject.repository.UserRepository;
import uz.testproject.repository.XabarnomaRepository;
import uz.testproject.service.XabarnomaService;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class XabarnomaImpl implements XabarnomaService {

    private final XabarnomaRepository xabarnomaRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<?> addXabarnoma(XabarnomaPayload payload) {
        try {
            Xabarnoma xabarnoma=new Xabarnoma();
            xabarnoma.setBody(payload.getBody());
            User user=userRepository.findByUsername(payload.getUserName());
            xabarnoma.setUser(user);
            xabarnoma=xabarnomaRepository.save(xabarnoma);
            if (xabarnoma != null) {
                return ResponseEntity.ok(new Result(true, "created xabarnoma succesfull", xabarnoma));
            } else {
                return ResponseEntity.ok(new Result(false, "xabarnoma error in save", null));
            }
        } catch (Exception e) {
            log.error("add xabarnoma error -> {}", e.getMessage());
            return ResponseEntity.ok(new Result(false, "xabarnoma error in save", null));
        }
    }


    @Override
    public ResponseEntity<?> editXabarnoma(XabarnomaPayload payload) {
        try {
            Xabarnoma xabarnoma=xabarnomaRepository.findById(payload.getId()).get();
            xabarnoma.setBody(payload.getBody());
            User user=userRepository.findByUsername(payload.getUserName());
            xabarnoma.setUser(user);
            xabarnoma=xabarnomaRepository.save(xabarnoma);
            if (xabarnoma != null) {
                return ResponseEntity.ok(new Result(true, "edit xabarnoma succesfull", null));
            } else {
                return ResponseEntity.ok(new Result(false, "xabarnoma error in edit", null));
            }
        } catch (Exception e) {
            log.error("edit xabarnoma error -> {}", e.getMessage());
            return ResponseEntity.ok(new Result(false, "xabarnoma error in edit", null));
        }
    }

    @Override
    public ResponseEntity<?> getXabarnomaUsername(String username){
        try {
            List<Xabarnoma> xabarnomaList=xabarnomaRepository.findByUserUsername(username);
            if (xabarnomaList != null) {
                return ResponseEntity.ok(new Result(true, "getXabarnomaUsername xabarnoma succesfull", xabarnomaList));
            } else {
                return ResponseEntity.ok(new Result(false, "xabarnoma error in getXabarnomaUsername", null));
            }
        } catch (Exception e) {
            log.error("getXabarnomaUsername xabarnoma error -> {}", e.getMessage());
            return ResponseEntity.ok(new Result(false, "xabarnoma error in getXabarnomaUsername", null));
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            xabarnomaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error("delete news");
            return false;
        }
    }


}
