package uz.testproject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.testproject.entity.News;
import uz.testproject.entity.Qarorlar;
import uz.testproject.entity.Tolovlar;
import uz.testproject.payload.NewsPayload;

import java.util.List;

@Repository
public interface TolovlarRepository extends JpaRepository<Tolovlar, Long> {

//    @Query("select new uz.zako.oquv_markaz.payload.NewsPayload(n.id,n.title,n.body,n.img.hashId,n.categorys.id) from Qarorlar n where n.categorys.id=:categoryId")
//    Page<NewsPayload> findAllByPage(Pageable pageable, @Param("categoryId") Long id);

    List<Tolovlar> findByUserId(Long id);

    List<Tolovlar> findByUserUsername(String user);

//    @Query("select new uz.testproject.payload.NewsPayload(n.id,n.title,n.body,n.img.hashId,n.date) from News n")
//    Page<NewsPayload> findAllByPage(Pageable pageable);

}
