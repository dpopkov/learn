package com.apress.ravi.rest;

import com.apress.ravi.dto.UserDTO;
import com.apress.ravi.exception.CustomErrorType;
import com.apress.ravi.repository.UserJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRegistrationRestController {
    public static final Logger logger = LoggerFactory.getLogger(UserRegistrationRestController.class);

    private UserJpaRepository userJpaRepository;

    @Autowired
    public void setUserJpaRepository(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> listAllUsers() {
        List<UserDTO> users = userJpaRepository.findAll();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> createUser(@RequestBody final UserDTO user) {
        if (userJpaRepository.findByName(user.getName()) != null) {
            return new ResponseEntity<>(new CustomErrorType("Unable to create new user. "
                    + "A user with name " + user.getName() + " already exists"),
                    HttpStatus.CONFLICT);
        }
        userJpaRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") final Long id) {
        UserDTO user = userJpaRepository.findOne(id);
        if (user == null) {
            return new ResponseEntity<>(new CustomErrorType("User with id " + id + " not found"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") final Long id, @RequestBody UserDTO user) {
        // fetch user based on id and set it to currentUser
        UserDTO currentUser = userJpaRepository.findOne(id);
        if (currentUser == null) {
            return new ResponseEntity<>(new CustomErrorType("Unable to update. "
                    + "User with id " + id + " not found"), HttpStatus.NOT_FOUND);
        }

        // update currentUser object data with user object data
        currentUser.setName(user.getName());
        currentUser.setAddress(user.getAddress());
        currentUser.setEmail(user.getEmail());

        // save currentUser
        userJpaRepository.saveAndFlush(currentUser);

        return new ResponseEntity<>(currentUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable("id") final Long id) {
        UserDTO user = userJpaRepository.findOne(id);
        if (user == null) {
            return new ResponseEntity<>(new CustomErrorType("Unable to delete. "
                    + "User with id " + id + " not found"), HttpStatus.NOT_FOUND);
        }
        userJpaRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
