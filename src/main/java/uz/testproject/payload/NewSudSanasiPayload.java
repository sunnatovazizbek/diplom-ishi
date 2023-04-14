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

    String body;

    private boolean dateActive;

    private String user;

    public NewSudSanasiPayload(String date, String body, String region, String user,boolean dateActive) {
        this.date = date;
        this.region = region;
        this.user = user;
        this.body=body;
        this.dateActive=dateActive;
    }
}
