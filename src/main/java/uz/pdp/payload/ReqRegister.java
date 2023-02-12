package uz.pdp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReqRegister {
    private String fullname;
    private String phonenumber;
    private String password;
    private String repassword;
}
