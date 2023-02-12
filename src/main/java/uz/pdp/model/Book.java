package uz.pdp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Book {
    private Integer id;
    private String title;
    private String author;
    private Double price;
    private Integer quantity;
    private Integer year;
    private boolean deleted;
    private String language;

}
