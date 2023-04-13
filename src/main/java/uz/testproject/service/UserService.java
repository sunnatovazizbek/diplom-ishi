package uz.testproject.service;

import org.springframework.http.ResponseEntity;
import uz.testproject.payload.UserPayload;

public interface UserService {


    ResponseEntity<?> saveUser(UserPayload payload);

    ResponseEntity<?> checkUser(UserPayload payload);

    ResponseEntity<?> getAllUsers();

    ResponseEntity<?> getAllPageUsers(int page, int size);

    ResponseEntity<?> editUser(UserPayload payload);

    ResponseEntity<?> deleteUserId(Long id);
}
