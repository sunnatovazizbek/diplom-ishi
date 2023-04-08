package uz.testproject.payload;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QarorlarPayload {

    private Long id;
    private String title;
    private String body;

    public QarorlarPayload(String title, String body) {
        this.title = title;
        this.body = body;
    }
}
