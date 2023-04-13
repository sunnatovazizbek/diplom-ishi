package uz.testproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import uz.testproject.entity.abstractEntity.AbstractEntity;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "foydalanuvchi")
public class User extends AbstractEntity {

//    @Column(unique = true, columnDefinition = "TEXT")
    private String username;

    private String password;

    private String fullName;

    private String adress;

    private String phoneNumber;

}
