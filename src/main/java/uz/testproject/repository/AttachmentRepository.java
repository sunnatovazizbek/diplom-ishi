package uz.testproject.repository;

import javax.persistence.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.testproject.entity.Attachment;
import java.util.List;
import java.util.Optional;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {

    Attachment findByHashId(String hashId);

    @Query(value = "select * from attachment a where a.hash_id=:hashId ORDER BY a.created_at DESC;", nativeQuery = true)
    Optional<Attachment> findByHashId1(@Param("hashId") String hashId);

    @OrderBy("id ASC ")
    List<Attachment> findAll();

    @Modifying
    boolean deleteByHashId(String hashId);

    @Query(nativeQuery = true, value = "select a.hash_id from attachment a where a.product_id=?1 limit 1")
    String getByProductsId(Long productId);

}
