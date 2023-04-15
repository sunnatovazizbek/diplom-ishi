package uz.testproject.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import lombok.*;
import uz.testproject.entity.User;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class XabarnomaPayload {

    private Long id;

    private String body;

    private String userName;

    private String answer;

    public XabarnomaPayload(String body, String userName) {
        this.body = body;
        this.userName = userName;
    }

    public XabarnomaPayload(String body, String userName, String answer) {
        this.body = body;
        this.userName = userName;
        this.answer = answer;
    }
}
