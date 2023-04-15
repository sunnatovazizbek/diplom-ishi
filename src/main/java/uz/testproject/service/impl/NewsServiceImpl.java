package uz.testproject.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.testproject.entity.News;
import uz.testproject.model.Result;
import uz.testproject.payload.NewsPayload;
import uz.testproject.repository.AttachmentRepository;
import uz.testproject.repository.NewsRepository;
import uz.testproject.service.NewsService;

@Service
@Slf4j
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;
    private final AttachmentRepository attachmentRepository;

    @Override
    public ResponseEntity<?> addNews(NewsPayload newsPayload) {
        try {
            News news = new News();
            news.setTitle(newsPayload.getTitle());
            news.setBody(newsPayload.getBody());
            news.setDate(newsPayload.getDate());
            if (newsPayload.getImg()!=null) {
                news.setImg(attachmentRepository.findByHashId(newsPayload.getImg()));
            }
            System.out.println("keldi news = " + news.toString());
            news = newsRepository.save(news);
            if (news != null) {
                return ResponseEntity.ok(new Result(true, "created succesfull", null));
            } else {
                return ResponseEntity.ok(new Result(false, "error", null));
            }
        } catch (Exception e) {
            log.error("add news error -> {}", e.getMessage());
            return ResponseEntity.ok(new Result(false, "News error in save", null));
        }
    }

    @Override
    public ResponseEntity<?> editNews(NewsPayload newsPayload) {
        try {
            News news = newsRepository.findById(newsPayload.getId()).get();
            news.setTitle(newsPayload.getTitle());
            news.setBody(newsPayload.getBody());
            news.setDate(newsPayload.getDate());
            if (newsPayload.getImg()!=null) {
                news.setImg(attachmentRepository.findByHashId(newsPayload.getImg()));
            }
            news = newsRepository.save(news);
            if (news != null) {
                return ResponseEntity.ok(new Result(true, "edit news succesfull", null));
            } else {
                return ResponseEntity.ok(new Result(false, "News error in edit", null));
            }
        } catch (Exception e) {
            log.error("edit news error -> {}", e.getMessage());
            return ResponseEntity.ok(new Result(false, "News error in edit", null));
        }
    }

    @Override
    public ResponseEntity<?> editNewsHashId(NewsPayload newsPayload) {
        try {
            News news = newsRepository.findById(newsPayload.getId()).get();
            if (newsPayload.getImg()!=null) {
                news.setImg(attachmentRepository.findByHashId(newsPayload.getImg()));
            }
            news = newsRepository.save(news);
            if (news != null) {
                return ResponseEntity.ok(new Result(true, "edit news succesfull", null));
            } else {
                return ResponseEntity.ok(new Result(false, "News error in edit", null));
            }
        } catch (Exception e) {
            log.error("edit news error -> {}", e.getMessage());
            return ResponseEntity.ok(new Result(false, "News error in edit", null));
        }
    }

    @Override
    public ResponseEntity<?> getPage(int page, int size) {

        try {
            PageRequest request = PageRequest.of(page, size);
            Page<News> newsPayloads = newsRepository.findAllByPage(request);
            for (int i = 0; i < newsPayloads.getContent().size(); i++) {
                newsPayloads.getContent().get(i).setImg(newsPayloads.getContent().get(i).getImg());
            }
            if (newsPayloads != null) {
                return ResponseEntity.ok(new Result(true, "edit news succesfull", newsPayloads));
            } else {
                return ResponseEntity.ok(new Result(false, "error", null));
            }
        } catch (Exception e) {
            log.error("edit news error -> {}", e.getMessage());
            return new ResponseEntity(new Result(false, "edit news error", null), HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<?> getNewsBody(Long id) {

        try {
            NewsPayload newsPayload=newsRepository.findNewsBody(id);
            return ResponseEntity.ok(newsPayload);
        } catch (Exception e) {
            log.error("getNewsBody");
            return new ResponseEntity(new Result(false, "error", null), HttpStatus.CONFLICT);
        }
    }

    @Override
    public ResponseEntity<?> getAllNews() {

        try {
            return ResponseEntity.ok(newsRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt")));
        } catch (Exception e) {
            log.error("getNewsBody");
            return new ResponseEntity(new Result(false, "error", null), HttpStatus.CONFLICT);
        }
    }

    @Override
    public Page<News> getPageNews(int page, int size) {

        PageRequest request = PageRequest.of(page, size);
        Page<News> news = newsRepository.findAllByPage(request);

        System.out.println(news.getContent().size() + " ");

        for (int i = 0; i < news.getContent().size(); i++) {
            news.getContent().get(i).setImg(news.getContent().get(i).getImg());
        }
        return news;

    }


    @Override
    public boolean deleteById(Long id) {
        try {
            newsRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error("delete news");
            return false;
        }
    }


}
