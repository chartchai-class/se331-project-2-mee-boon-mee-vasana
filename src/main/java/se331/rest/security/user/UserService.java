package se331.rest.security.user;

import jakarta.transaction.Transactional;

import java.util.Optional;

public interface UserService {
    User save(User user);

    void deleteById(Integer id);
    Optional<User> updateRole(int id, User user);

    @Transactional
    User findByUsername(String username);
}