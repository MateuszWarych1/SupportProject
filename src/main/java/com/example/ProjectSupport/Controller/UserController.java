package com.example.ProjectSupport.Controller;

import com.example.ProjectSupport.Service.UserService;
import com.example.ProjectSupport.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginRequest", new UserModel());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserModel userModel, Model model){
        System.out.println("login request: " + userModel);
        UserModel authenticate = userService.authenticate(userModel.getLogin(), userModel.getPassword());
        if (authenticate != null){
            model.addAttribute("userLogin", authenticate.getLogin());
            return "/report";
        }else {
            return "error_page";
        }
    }

    @GetMapping("/registration")
    public String getRegistration(Model model){
        model.addAttribute("registerRequest", new UserModel());
        return "registration";
    }
    @PostMapping("/registration")
    public String registration(@ModelAttribute UserModel userModel){
        System.out.println("register request: " + userModel);
        UserModel registerUser = userService.registerUser(userModel.getLogin(),
                userModel.getPassword(), userModel.getEmail());
        return registerUser == null ? "error_page" : "redirect:/login";
    }
}

