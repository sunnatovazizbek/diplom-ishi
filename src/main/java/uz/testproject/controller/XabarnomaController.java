package uz.testproject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.testproject.payload.NewsPayload;
import uz.testproject.payload.XabarnomaPayload;
import uz.testproject.repository.XabarnomaRepository;
import uz.testproject.service.NewsService;
import uz.testproject.service.XabarnomaService;

@RestController
@RequestMapping("/api/xabarnoma")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class XabarnomaController {

    private final XabarnomaService xabarnomaService;
    private final XabarnomaRepository xabarnomaRepository;

    @PostMapping("/save")
    public ResponseEntity<?> saveXabarnoma(@RequestBody XabarnomaPayload payload){
        return xabarnomaService.addXabarnoma(payload);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editXabarnoma(@RequestBody XabarnomaPayload payload){
        return xabarnomaService.editXabarnoma(payload);
    }

    @DeleteMapping("/{xabarnomaId}")
    public boolean deleteXabarnomaId(@PathVariable("xabarnomaId") Long id){
        return xabarnomaService.deleteById(id);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<?> UserNameXabarnoma(@PathVariable("userName") String username){
        return xabarnomaService.getXabarnomaUsername(username);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllIdBody(){
        return ResponseEntity.ok(xabarnomaRepository.findAll());
    }




}
