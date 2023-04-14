package uz.testproject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.testproject.payload.NewsPayload;
import uz.testproject.payload.SudlanganlikHaqidaPayload;
import uz.testproject.service.NewsService;
import uz.testproject.service.SudlanganlikHaqidaService;

@RestController
@RequestMapping("/api/sudlanganlikAbout")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class SudLanganLikHaqidaMalumotController {

    private final SudlanganlikHaqidaService sudlanganlikHaqidaService;

    @PostMapping("/save")
    public ResponseEntity<?> saveSudlanganlikAbout(@RequestBody SudlanganlikHaqidaPayload payload){
        return sudlanganlikHaqidaService.saveSudlanganlikHaqida(payload);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editSudlanganlikAbout(@RequestBody SudlanganlikHaqidaPayload payload){
        return sudlanganlikHaqidaService.editSudlanganlikHaqidaMalumot(payload);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<?> getSudlanganlikAboutListPage(@PathVariable("userName") String userName){
        return sudlanganlikHaqidaService.getSudlanganlikHaqidaMalumot(userName);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<?> SudlanganlikAboutIdBody(@PathVariable("Id") Long id){
        return sudlanganlikHaqidaService.deleteSudlanganlikHaqidaMalumot(id);
    }

}
