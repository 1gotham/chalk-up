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
        User newUser = new User();

        //Dodac indywidualne exceptiony
        if(userRepository.findByUsername(registerRequest.getUsername()) != null){
            throw new IllegalArgumentException("User with this name already exists");
        }

        if(userRepository.findByEmail(registerRequest.getEmail()) != null){
            throw new IllegalArgumentException("User with this email already exists");
        }

        newUser.setUsername(registerRequest.getUsername());
        newUser.setEmail(registerRequest.getEmail());
        newUser.setPassword(registerRequest.getPassword()); // zrobic hashowanie

        userRepository.save(newUser);

        return new RegisterResponse(registerRequest.getUsername(), "Registration successful");
    }
}
