package uz.testproject.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserPayload {

    private Long id;

    private String username;
    private String password;
    private String fullName;
    private String phone;
    private String adress;

    public UserPayload(String username, String password, String fullName, String phone, String adress) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.phone = phone;
        this.adress = adress;
    }

    public UserPayload(String username, String password, String fullName, String phone) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.phone = phone;
    }

    public UserPayload(String username, String password, String fullName) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
    }
}
