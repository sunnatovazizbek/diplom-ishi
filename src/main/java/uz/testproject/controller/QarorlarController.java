package uz.testproject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.testproject.payload.NewsPayload;
import uz.testproject.payload.QarorlarPayload;
import uz.testproject.repository.QarorlarRepository;
import uz.testproject.service.NewsService;
import uz.testproject.service.QarorlarService;

@RestController
@RequestMapping("/api/qaror")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class QarorlarController {

    private final QarorlarService qarorlarService;
    private final QarorlarRepository qarorlarRepository;

    @PostMapping("/save")
    public ResponseEntity<?> saveQaror(@RequestBody QarorlarPayload payload){
        return qarorlarService.addQarorlar(payload);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editQaror(@RequestBody QarorlarPayload payload){
        return qarorlarService.editQarorlar(payload);
    }

    @DeleteMapping("/{qarorId}")
    public boolean getQarorListPage(@PathVariable("qarorId") Long id){
        return qarorlarService.deleteById(id);
    }

    @GetMapping("/all")
    public ResponseEntity<?> allQaror(){
        return ResponseEntity.ok(qarorlarRepository.findAll());
    }

//    @GetMapping("/{userName}")
//    public ResponseEntity<?> getQarorlarUserName(@RequestParam("userName") String userName){
//        return qarorlarService.
//    }

}
