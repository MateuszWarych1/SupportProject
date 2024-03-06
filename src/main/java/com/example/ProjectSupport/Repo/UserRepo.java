package com.example.ProjectSupport.Repo;

import com.example.ProjectSupport.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserModel, Integer> {

    Optional<UserModel> findByLoginAndPassword(String login, String password);
}
