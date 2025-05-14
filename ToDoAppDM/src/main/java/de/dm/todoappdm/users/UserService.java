package de.dm.todoappdm.users;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;




    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }




    public User createUser(User user) {
        return userRepository.save(user);
    }


    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + id));
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User updateUser(Long id, User updatedUser) {
        User existing = getUserById(id);
        existing.setLogin(updatedUser.getLogin());
        existing.setPassword(updatedUser.getPassword());
        return userRepository.save(existing);
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
