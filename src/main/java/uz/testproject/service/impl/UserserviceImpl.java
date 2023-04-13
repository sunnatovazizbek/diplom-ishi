package uz.testproject.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.testproject.entity.User;
import uz.testproject.model.Result;
import uz.testproject.payload.UserPayload;
import uz.testproject.repository.UserRepository;
import uz.testproject.service.UserService;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserserviceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<?> saveUser(UserPayload payload) {
        try {

            User user = new User();

            user.setUsername(payload.getUsername());
            user.setPassword(payload.getPassword());
            user.setFullName(payload.getFullName());
            user.setAdress(payload.getAdress());
            user.setPhoneNumber(payload.getPhone());
            if (payload.getPassword().length() >= 6) {
                user = userRepository.save(user);
                if (user != null) {
                    return ResponseEntity.ok(new Result(true, "save succesfull", user));
                }
            } else {
                return ResponseEntity.ok(new Result(false, "password kiritishda xatolik", null));
            }
        } catch (Exception e) {
            log.error("error user", e.getMessage());
            return new ResponseEntity(new Result(false, "save not succesfull", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return null;
    }

    @Override
    public ResponseEntity<?> checkUser(UserPayload payload) {
        try {

            User user = userRepository.findByUsername(payload.getUsername());
            if (user != null) {
                if (user.getPassword().equals(payload.getPassword())) {
                    return ResponseEntity.ok(new Result(true, "Shaxsiy kabinetga hush kelibsz", null));
                }else {
                    return ResponseEntity.ok(new Result(false, "password kiritishda xatolik", null));
                }
            }
            return new ResponseEntity(new Result(false, "user not found", null), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            log.error("error user", e.getMessage());
            return new ResponseEntity(new Result(false, "save not succesfull", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getAllUsers() {
        try {
            List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
            if (users != null) {
                return ResponseEntity.ok(new Result(true, "getUsercenterBranchesId", users));
            }
            return new ResponseEntity(new Result(false, "error user", null), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("error user", e.getMessage());
            return new ResponseEntity(new Result(false, "error user", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getAllPageUsers(int page, int size) {
        try {
            Page<User> users = userRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdAt")));
            if (users != null) {
                return ResponseEntity.ok(new Result(true, "getUsercenterBranchesId", users));
            }
            return new ResponseEntity(new Result(false, "error user", null), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("error user", e.getMessage());
            return new ResponseEntity(new Result(false, "error user", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> editUser(UserPayload payload) {
        try {
            User user = userRepository.findById(payload.getId()).get();
            user.setUsername(payload.getUsername());
            user.setFullName(payload.getFullName());
            user.setPhoneNumber(payload.getPhone());
            user.setAdress(payload.getAdress());
            user.setPassword(payload.getPassword());
            user = userRepository.save(user);
            if (user != null) {
                return ResponseEntity.ok(new Result(true, "edit succesfull", user));
            }
            return new ResponseEntity(new Result(false, "edit not succesfull", null), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("error user", e.getMessage());
            return new ResponseEntity(new Result(false, "edit not succesfull", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> deleteUserId(Long id) {
        try {
            userRepository.deleteById(id);
            return ResponseEntity.ok("delete succesfull");
        } catch (Exception e) {
            log.error("error user", e.getMessage());
            return new ResponseEntity(new Result(false, "delete not succesfull", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
