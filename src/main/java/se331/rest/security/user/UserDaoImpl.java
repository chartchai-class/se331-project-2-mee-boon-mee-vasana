package se331.rest.security.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {
    final UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }


    @Override
    public Optional<User> updateRole(int id, User user) {
        Optional<User> users = userRepository.findById(id);
        if (user.getEnabled()) {
            User newUser = new User();
            newUser.setId(user.getId());
            newUser.setUsername(user.getUsername());
            newUser.setEmail(user.getEmail());
            newUser.setRoles(user.getRoles());
            newUser.setPassword(user.getPassword());
            newUser.setTimestamp(user.getTimestamp());


            return Optional.of(userRepository.save(newUser));
        }


        return Optional.empty();
    }
}