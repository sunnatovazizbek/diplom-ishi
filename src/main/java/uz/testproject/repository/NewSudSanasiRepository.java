package uz.testproject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.testproject.entity.NewSudSanasi;
import uz.testproject.entity.News;
import uz.testproject.entity.Qarorlar;
import uz.testproject.payload.NewSudSanasiPayload;
import uz.testproject.payload.NewsPayload;

import java.util.List;

@Repository
public interface NewSudSanasiRepository extends JpaRepository<NewSudSanasi, Long> {

    @Query("select new uz.testproject.payload.NewSudSanasiPayload(n.id,n.date,n.body, n.region, n.dateActive) from NewSudSanasi n")
    List<NewSudSanasiPayload> getByUsername(String username);

}
