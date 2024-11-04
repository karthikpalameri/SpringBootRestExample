package com.kk.spring_boot_rest.repo;

import com.kk.spring_boot_rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    /**
     * Retrieves a user by their username.
     *
     * @param username the username of the user to be retrieved
     * @return the user with the specified username or null if no user is found
     */
    User findByUsername(String username);
}
