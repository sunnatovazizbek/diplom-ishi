package uz.testproject.service;


import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import uz.testproject.entity.News;
import uz.testproject.payload.NewsPayload;

import java.util.List;

public interface NewsService {


    ResponseEntity<?> saveNewsList(List<NewsPayload> payloadList);

    ResponseEntity<?> addNews(NewsPayload newsPayload);

    ResponseEntity<?> editNews(NewsPayload newsPayload);

    ResponseEntity<?> editNewsHashId(NewsPayload newsPayload);

    ResponseEntity<?> getPage(int page, int size);

    ResponseEntity<?> getNewsBody(Long id);

    ResponseEntity<?> getAllNews();

    Page<News> getPageNews(int page, int size);

    boolean deleteById(Long id);
}
