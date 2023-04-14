package uz.testproject.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.testproject.entity.NewSudSanasi;
import uz.testproject.entity.User;
import uz.testproject.model.Result;
import java.util.List;
import uz.testproject.payload.NewSudSanasiPayload;
import uz.testproject.repository.NewSudSanasiRepository;
import uz.testproject.repository.UserRepository;
import uz.testproject.service.NewSudSanasiService;

@Service
@Slf4j
@RequiredArgsConstructor
public class NewSudSanasiImpl implements NewSudSanasiService {

    private final NewSudSanasiRepository newSudSanasiRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<?> addSudDate(NewSudSanasiPayload payload) {
        try {
            NewSudSanasi newSudSanasi=new NewSudSanasi();
            newSudSanasi.setRegion(payload.getRegion());
            newSudSanasi.setDate(payload.getDate());
            newSudSanasi.setBody(payload.getBody());
            User user=userRepository.findByUsername(payload.getUser());
            newSudSanasi.setUser(user);
            newSudSanasi = newSudSanasiRepository.save(newSudSanasi);
            if (newSudSanasi != null) {
                return ResponseEntity.ok(new Result(true, "created dateSudSanasi succesfull", null));
            } else {
                return ResponseEntity.ok(new Result(false, "NewSudDate error in save", null));
            }
        } catch (Exception e) {
            log.error("add news error -> {}", e.getMessage());
            return ResponseEntity.ok(new Result(false, "NewSudDate error in save", null));
        }
    }

    @Override
    public ResponseEntity<?> editNews(NewSudSanasiPayload payload) {
        try {
            NewSudSanasi newSudSanasi=newSudSanasiRepository.findById(payload.getId()).get();
            newSudSanasi.setRegion(payload.getRegion());
            newSudSanasi.setDate(payload.getDate());
            newSudSanasi.setBody(payload.getBody());
            User user=userRepository.findByUsername(payload.getUser());
            newSudSanasi.setUser(user);
            newSudSanasi = newSudSanasiRepository.save(newSudSanasi);
            if (newSudSanasi != null) {
                return ResponseEntity.ok(new Result(true, "edit dateSudSanasi succesfull", null));
            } else {
                return ResponseEntity.ok(new Result(false, "NewSudDate error in edit", null));
            }
        } catch (Exception e) {
            log.error("edit dateSudSanasi error -> {}", e.getMessage());
            return ResponseEntity.ok(new Result(false, "NewSudDate error in edit", null));
        }
    }

//    @Override
//    public ResponseEntity<?> getPage(int page, int size) {
//
//        try {
//            PageRequest request = PageRequest.of(page, size);
//            Page<NewsPayload> newsPayloads = newsRepository.findAllByPage(request);
//            for (int i = 0; i < newsPayloads.getContent().size(); i++) {
//                newsPayloads.getContent().get(i).setImg(newsPayloads.getContent().get(i).getImg());
//            }
//            if (newsPayloads != null) {
//                return ResponseEntity.ok(new Result(true, "edit news succesfull", newsPayloads));
//            } else {
//                return new ResponseEntity(new Result(false, "error", null), HttpStatus.BAD_REQUEST);
//            }
//        } catch (Exception e) {
//            log.error("edit news error -> {}", e.getMessage());
//            return new ResponseEntity(new Result(false, "edit news error", null), HttpStatus.BAD_REQUEST);
//        }
//
//    }


    @Override
    public ResponseEntity<?> getNewDateSanasi(String username){
        try {
            List<NewSudSanasiPayload> newSudSanasiPayloadList=newSudSanasiRepository.getByUsername(username);
            if (newSudSanasiPayloadList != null) {
                return ResponseEntity.ok(new Result(true, "get New DateSanasi succesfull", newSudSanasiPayloadList));
            } else {
                return new ResponseEntity(new Result(false, "error New DateSanasi", null), HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            log.error("New DateSanasi error -> {}", e.getMessage());
            return new ResponseEntity(new Result(false, "New DateSanasi error", null), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            newSudSanasiRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error("delete news");
            return false;
        }
    }


}
