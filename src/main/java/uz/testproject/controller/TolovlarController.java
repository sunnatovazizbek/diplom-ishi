package uz.testproject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.testproject.payload.NewsPayload;
import uz.testproject.payload.TolovlarPayload;
import uz.testproject.service.NewsService;
import uz.testproject.service.TolovlarService;

@RestController
@RequestMapping("/api/tolov")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class TolovlarController {

    private final TolovlarService tolovlarService;

    @PostMapping("/save")
    public ResponseEntity<?> saveTolov(@RequestBody TolovlarPayload payload){
        return tolovlarService.saveTolovlar(payload);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editTolov(@RequestBody TolovlarPayload payload){
        return tolovlarService.editTolovlar(payload);
    }

    @DeleteMapping("/{tolovId}")
    public ResponseEntity<?> deleteTolov(@PathVariable("tolovId") Long id){
        return tolovlarService.deleteTolovlarId(id);
    }

    @GetMapping("/all")
    public ResponseEntity<?> allTolov(){
        return tolovlarService.getAllTolovlar();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> tolovlarUserName(@PathVariable("userId") Long userId){
        return tolovlarService.getTolovlarUserId(userId);
    }


}
