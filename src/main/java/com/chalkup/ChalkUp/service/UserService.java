package com.chalkup.ChalkUp.service;

import com.chalkup.ChalkUp.dto.auth.RegisterRequest;
import com.chalkup.ChalkUp.dto.auth.RegisterResponse;
import com.chalkup.ChalkUp.model.User;
import com.chalkup.ChalkUp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User deleteuser(Long id){
        return userRepository.deleteUserById(id);
    }

    public RegisterResponse registerResponse(RegisterRequest registerRequest){
        //sprawdzenie czy istnieje username,email
        User newUser = new User();

        newUser.setUsername(registerRequest.getUsername());
        newUser.setEmail(registerRequest.getEmail());
        newUser.setPassword(registerRequest.getPassword()); // zrobic hashowanie

        userRepository.save(newUser);

        return new RegisterResponse(registerRequest.getUsername(), "Rejestracja zakończona sukcesem");
    }
}
