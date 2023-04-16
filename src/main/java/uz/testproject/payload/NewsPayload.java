package uz.testproject.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewsPayload {

    private Long id;

    @Column(columnDefinition = "TEXT")
    private String title;
    @Column(columnDefinition = "TEXT")
    private String body;

    private String imgUrl;
    private String date;

    public NewsPayload(String title, String body, String imgUrl, String date) {
        this.title = title;
        this.body = body;
        this.imgUrl = imgUrl;
        this.date = date;
    }

    public NewsPayload(String body) {
        this.body = body;
    }
}
