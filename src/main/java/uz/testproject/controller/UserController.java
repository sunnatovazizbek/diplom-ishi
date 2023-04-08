package uz.testproject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.testproject.payload.NewsPayload;
import uz.testproject.payload.UserPayload;
import uz.testproject.service.NewsService;
import uz.testproject.service.UserService;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody UserPayload payload){
        return userService.saveUser(payload);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editUser(@RequestBody UserPayload payload){
        return userService.editUser(payload);
    }

    @GetMapping("/")
    public ResponseEntity<?> getUserListPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int size){
        return userService.getAllPageUsers(page, size);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUserId(@PathVariable("userId") Long id){
        return userService.deleteUserId(id);
    }

    @GetMapping("/all")
    public ResponseEntity<?> allUser(){
        return userService.getAllUsers();
    }





}
