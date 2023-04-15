package uz.testproject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.testproject.payload.NewsPayload;
import uz.testproject.service.NewsService;

@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class NewsController {

    private final NewsService newsService;

    @PostMapping("/save")
    public ResponseEntity<?> saveNews(@RequestBody NewsPayload payload){
        return newsService.addNews(payload);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editNews(@RequestBody NewsPayload payload){
        return newsService.editNews(payload);
    }

    @PutMapping("/edit/hashId")
    public ResponseEntity<?> editNewsHashId(@RequestBody NewsPayload payload){
        return newsService.editNewsHashId(payload);
    }

    @GetMapping("/")
    public ResponseEntity<?> getNewsListPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int size){
        return newsService.getPage(page, size);
    }

    @DeleteMapping("/{newsId}")
    public boolean deleteNewsId(@PathVariable("newsId") Long id){
        return newsService.deleteById(id);
    }

    @GetMapping("/all")
    public ResponseEntity<?> allNews(){
        return newsService.getAllNews();
    }

    @GetMapping("/{newsid}")
    public ResponseEntity<?> NewsIdBody(@PathVariable("newsid") Long id){
        return newsService.getNewsBody(id);
    }




}
