package se331.rest.security.user;

import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface UserDao {
    User findByUsername(String username);

    User save(User user);
    void deleteById(Integer id);
    Optional<User> updateRole(int id, User user);
}