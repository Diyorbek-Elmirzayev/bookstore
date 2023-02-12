package uz.pdp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.model.User;
import uz.pdp.payload.ReqLogin;
import uz.pdp.payload.ReqRegister;
import uz.pdp.service.AuthService;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(
            @ModelAttribute ReqRegister reqRegister,
            Model model
    ) {
        try {
            authService.register(reqRegister);
            return "signIn";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Something went wrong");
            return "redirect:/auth/register";
        }
    }


    @GetMapping("/login")
    public String login() {
        return "signIn";
    }

    @PostMapping("/login")
    public String login(
            @ModelAttribute ReqLogin reqLogin, Model model
    ) {
        try {
            User user = authService.login(reqLogin);

            if (user != null) {
                if (user.getRole().equals("CLIENT")) {
                    model.addAttribute("user",user);
                    return "userCabinet";
                }
                model.addAttribute("user",user);
                return "adminCabinet";
            }
            model.addAttribute("errorMessage", "Phone number or password error");
            return "redirect:/auth/login";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Phone number or password error");
            return "redirect:/auth/login";
        }
    }
}
