package uz.testproject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.testproject.entity.News;
import uz.testproject.entity.Qarorlar;
import uz.testproject.entity.SudlanganlikHaqidaMalumot;
import uz.testproject.payload.NewsPayload;

import java.util.List;

@Repository
public interface SudlanganlikHaqidaRepository extends JpaRepository<SudlanganlikHaqidaMalumot, Long> {

    List<SudlanganlikHaqidaMalumot> findByUserUsername(String user);

}
