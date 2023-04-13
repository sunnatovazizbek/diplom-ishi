package uz.testproject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.testproject.payload.NewSudSanasiPayload;
import uz.testproject.payload.NewsPayload;
import uz.testproject.service.NewSudSanasiService;
import uz.testproject.service.NewsService;

@RestController
@RequestMapping("/api/sudDate")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class NewSudSanasiController {

    private final NewSudSanasiService newSudSanasiService;

    @PostMapping("/save")
    public ResponseEntity<?> saveNewSudSanasi(@RequestBody NewSudSanasiPayload payload){
        return newSudSanasiService.addSudDate(payload);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editNews(@RequestBody NewSudSanasiPayload payload){
        return newSudSanasiService.editNews(payload);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<?> getNewSudSanasi(@PathVariable("userName") String userName){
        return newSudSanasiService.getNewDateSanasi(userName);
    }

    @DeleteMapping("/{Id}")
    public boolean deleteById(@PathVariable("Id") Long Id){
        return newSudSanasiService.deleteById(Id);
    }




}
