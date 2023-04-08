package uz.testproject.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import lombok.*;
import uz.testproject.entity.Qarorlar;
import uz.testproject.entity.SudlanganlikHaqidaMalumot;
import uz.testproject.entity.User;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SudlanganlikHaqidaPayload {

    private Long id;

    private String region;

    private String date;

    private Long qarorId;

    private String userName;

    public SudlanganlikHaqidaPayload(String region, String date, Long qarorId, String userName) {
        this.region = region;
        this.date = date;
        this.qarorId = qarorId;
        this.userName = userName;
    }
}
