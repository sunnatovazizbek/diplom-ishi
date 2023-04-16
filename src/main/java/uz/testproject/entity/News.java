package uz.testproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import uz.testproject.entity.abstractEntity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.sql.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class News extends AbstractEntity {

    @Column(columnDefinition = "TEXT")
    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;

    private String date;

    @Column(columnDefinition = "TEXT")
    private String imgUrl;


}
