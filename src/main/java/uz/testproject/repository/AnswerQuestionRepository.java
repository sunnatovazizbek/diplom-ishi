package uz.testproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.testproject.entity.AnswerQuestion;
import uz.testproject.entity.Xabarnoma;
import uz.testproject.payload.AnswerQuestionPayload;

import java.util.List;

@Repository
public interface AnswerQuestionRepository extends JpaRepository<AnswerQuestion, Long> {


    @Query("select new uz.testproject.payload.AnswerQuestionPayload(a.id, a.answer, a.xabarnoma.body,a.xabarnoma.createdAt, a.createdAt) from AnswerQuestion a where a.xabarnoma.user.username=?1")
    List<AnswerQuestionPayload> getByUsernameAnswerQuestion(String username);


}
