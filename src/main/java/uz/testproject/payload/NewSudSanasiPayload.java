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

    public NewSudSanasiPayload(Long id,String date, String body, String region,boolean dateActive) {
        this.id=id;
        this.date = date;
        this.body=body;
        this.region = region;
        this.dateActive=dateActive;
    }
}
