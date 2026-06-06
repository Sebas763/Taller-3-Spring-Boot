package com.example.demo.services;

import com.example.demo.DemoApplication;
import java.util.List;
import java.util.UUID;

import com.example.demo.dtos.UserRequestDto;
import com.example.demo.entities.User;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Marks this class as a Spring service component.
public class UserService implements IUserService {

    private final DemoApplication demoApplication;
    @Autowired
    private UserRepository userRepository;

    UserService(DemoApplication demoApplication) {
        this.demoApplication = demoApplication;
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public User addUser(UserRequestDto userDto){
        var user = User
            .builder()
            .name(userDto.getName())
            .age(userDto.getAge())
            .resourceId(UUID.randomUUID())
            .build();
        return userRepository.addUser(user);
    }

    @Override
    public User getByResourceId(UUID resourceId){
        return userRepository.findByResourceId(resourceId)
            .orElseThrow(() -> new UserNotFoundException( "User no encontrado"));
    }

    @Override
    public User updateUser(UUID resourceId, UserRequestDto userDto) {
        var user = userRepository.findByResourceId(resourceId)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            user.setName(userDto.getName());
            user.setAge(userDto.getAge());
            return userRepository.updateUser(user);
    }

    @Override
    public void removeUser(UUID resourceId) {
        var user = userRepository.findByResourceId(resourceId)
        .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));

        userRepository.delete(user);
    }
}

