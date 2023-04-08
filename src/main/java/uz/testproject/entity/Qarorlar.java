package uz.testproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import lombok.*;
import uz.testproject.entity.abstractEntity.AbstractEntity;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Qarorlar extends AbstractEntity {

    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;

}
