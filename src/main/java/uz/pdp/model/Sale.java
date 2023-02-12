package uz.pdp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sale {
    private Integer id;
    private Integer userId;
    private double totalPrice;
    private Date date;
}
