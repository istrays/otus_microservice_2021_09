package com.strays.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public UserEntity getUser(@PathVariable Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("User with id %d id was not found", id)));
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public UserEntity updateUser(@PathVariable Integer id, @RequestBody UserEntity user) {
        UserEntity oldUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("User with id %d id was not found", id)));
        oldUser.setName(user.getName());
        oldUser.setCity(user.getCity());
        return userRepository.save(oldUser);
    }
}
