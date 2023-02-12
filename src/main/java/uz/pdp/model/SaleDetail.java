package uz.pdp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleDetail {
    private Integer id;
    private Integer saleId;
    private Integer bookId;
    private Integer quantity;
    private double totalPrice;

}
