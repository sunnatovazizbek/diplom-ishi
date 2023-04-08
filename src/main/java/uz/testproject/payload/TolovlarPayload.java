package uz.testproject.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TolovlarPayload {

    private Long id;
    private Double price;
    private String userName;

    private Long sudlanganlikHaqidaMalumotId;

    public TolovlarPayload(Double price, String userName, Long sudlanganlikHaqidaMalumotId) {
        this.price = price;
        this.userName = userName;
        this.sudlanganlikHaqidaMalumotId = sudlanganlikHaqidaMalumotId;
    }
}
