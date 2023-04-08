package uz.testproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.testproject.entity.Qarorlar;
import uz.testproject.entity.Xabarnoma;
import java.util.List;

@Repository
public interface XabarnomaRepository extends JpaRepository<Xabarnoma, Long> {

    List<Xabarnoma> findByUserUsername(String username);

}
