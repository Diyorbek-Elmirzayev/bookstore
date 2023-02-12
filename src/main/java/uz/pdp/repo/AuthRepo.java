package uz.pdp.repo;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import uz.pdp.model.User;
import uz.pdp.payload.ReqLogin;

@Component
@RequiredArgsConstructor
public class AuthRepo {

    private final JdbcTemplate jdbcTemplate;

    public void register(User user) {
        jdbcTemplate.update("insert into users(full_name,phone_number,password) values (?,?,?)",
                user.getFullName(),
                user.getPhoneNumber(),
                user.getPassword()
        );
    }

    public User login(ReqLogin reqLogin) {
     return    jdbcTemplate.query("select * from users" +
                        " where phone_number=?" +
                        " and password=?" +
                        " and deleted='false'",
                new Object[]{
                        reqLogin.getPhonenumber(),
                        reqLogin.getPassword()
                },
             new   BeanPropertyRowMapper<>(User.class)
                ).
                stream().findAny().orElse(null);
    }
}
