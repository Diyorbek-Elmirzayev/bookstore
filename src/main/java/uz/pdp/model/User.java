package uz.pdp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Integer id;
    private String fullName;
    private String phoneNumber;
    private String password;
    private Double balance;
    private String role;
    private boolean deleted;
}
