package uz.testproject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.testproject.entity.News;
import uz.testproject.entity.Qarorlar;
import uz.testproject.payload.NewsPayload;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

    void deleteById(Long id);

    News getById(Long id);

    @Query(nativeQuery = true, value = "select * from News n order by n.created_at desc")
    Page<News> findAllByPage(Pageable pageable);

    @Query("select new uz.testproject.payload.NewsPayload(n.body) from News n where n.id=?1")
    NewsPayload findNewsBody(Long id);

}
