package uz.testproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.testproject.entity.abstractEntity.AbstractEntity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Attachment extends AbstractEntity {

    @Column(nullable = false, length = 50)
    private String name;

    private String contentType;

    private Long fileSize;

    private String uploadPath;

    private String hashId;

    private String extension;

}
