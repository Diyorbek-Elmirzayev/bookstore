package uz.pdp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.model.User;
import uz.pdp.payload.ReqLogin;
import uz.pdp.payload.ReqRegister;
import uz.pdp.repo.AuthRepo;
@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepo authRepo;
    public void register(ReqRegister reqRegister) {
        User user = new User();
        user.setFullName(reqRegister.getFullname());
        user.setPhoneNumber(reqRegister.getPhonenumber());
        user.setPassword(reqRegister.getPassword());
        user.setBalance(0.0);
        user.setRole("CLIENT");
        user.setDeleted(false);
        authRepo.register(user);
    }

    public User login(ReqLogin reqLogin) {
       return authRepo.login(reqLogin);
    }
}
