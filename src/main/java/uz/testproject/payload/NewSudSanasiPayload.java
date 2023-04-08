package uz.testproject.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import lombok.*;
import uz.testproject.entity.User;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewSudSanasiPayload {

    private Long id;

    private String date;

    private String region;

    private String user;

    public NewSudSanasiPayload(String date, String region, String user) {
        this.date = date;
        this.region = region;
        this.user = user;
    }
}
