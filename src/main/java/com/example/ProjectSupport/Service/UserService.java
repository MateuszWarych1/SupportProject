package com.example.ProjectSupport.Service;

import com.example.ProjectSupport.Repo.UserRepo;
import com.example.ProjectSupport.model.UserModel;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserModel registerUser(String login, String password, String email ) {
        if (login == null || password == null) {
            return null;
        } else {
            UserModel userModel = new UserModel();
            userModel.setLogin(login);
            userModel.setPassword(password);
            userModel.setEmail(email);
            return userRepo.save(userModel);
        }
    }

    public UserModel authenticate(String login, String password){
        return userRepo.findByLoginAndPassword(login, password).orElse(null);
    }
}
