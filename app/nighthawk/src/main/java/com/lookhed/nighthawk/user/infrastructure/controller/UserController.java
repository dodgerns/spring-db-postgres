package com.lookhed.nighthawk.user.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lookhed.nighthawk.user.application.service.UserService;
import com.lookhed.nighthawk.user.domain.model.UserModel;
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel userModel) {
        UserModel createdUserModel = this.userService.createUser(userModel);
        return new ResponseEntity<>(createdUserModel, HttpStatus.CREATED);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserModel> getUserById(@PathVariable int userId) {
        return this.userService.getUserById(userId)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping
    public ResponseEntity<UserModel> updateUser(@RequestBody UserModel updatedUserModel) {
        return this.userService.updateUser(updatedUserModel)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteUser(@RequestBody UserModel deleteUserModel){
        boolean response = this.userService.deleteUser(deleteUserModel);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }
}
