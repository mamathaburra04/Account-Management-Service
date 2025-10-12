package com.mamatha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mamatha.entity.User;
import com.mamatha.exception.ResourceNotFoundException;
import com.mamatha.repository.UserRepository;

@Service
public class UserService {
	@Autowired
    private UserRepository repo;
	
	// Get all users
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    // Get a single user by ID
    public User getUserById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));
    }

    // Create a new user
    public User createUser(User user) {
        return repo.save(user);
    }

    // Update existing user
    public User updateUser(Long id, User user) {
        User existing = getUserById(id);

        existing.setUsername(user.getUsername());
        existing.setEmail(user.getEmail());
        existing.setPassword(user.getPassword());
        existing.setRole(user.getRole());
        existing.setActive(user.getActive());

        return repo.save(existing);
    }

    // Delete user by ID
    public void deleteUser(Long id) {
        User existing = getUserById(id);
        repo.delete(existing);
    }
}