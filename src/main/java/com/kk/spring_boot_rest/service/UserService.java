package com.kk.spring_boot_rest.service;

import com.kk.spring_boot_rest.model.User;
import com.kk.spring_boot_rest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BCryptPasswordEncoder encoder;// = new BCryptPasswordEncoder(12);

    /**
     * Save a user to the database.
     *
     * @param user the user to save
     * @return the saved user
     */
    public User saveUser(User user) {
        // Save user to database
        // Encode password
        user.setPassword(encoder.encode(user.getPassword()));
        // Save user
        userRepo.save(user);
        return user;
    }
}