package com.celebrato.backend.service;

import com.celebrato.backend.model.User;
import com.celebrato.backend.repository.UserRepository;
import com.celebrato.backend.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    }

    @Override
    public User updateUser(Long id, User userDetails) {
        User user = getUserById(id); // will throw if missing
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setPhone(userDetails.getPhone());
        user.setAddress(userDetails.getAddress());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }
}
