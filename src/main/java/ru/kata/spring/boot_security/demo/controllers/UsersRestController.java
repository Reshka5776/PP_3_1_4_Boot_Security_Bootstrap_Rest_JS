package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserDetailsServiceImpl;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/api")
public class UsersRestController {

    private final UserService userService;
    private final UserDetailsServiceImpl userDetailsService;
    private final RoleService roleService;

    @Autowired
    public UsersRestController(UserService userService, UserDetailsServiceImpl userDetailsService, RoleService roleService) {
        this.userService = userService;
        this.userDetailsService = userDetailsService;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public List<User> printAllUsers() {
        return userService.getAllUsers();
    }

//    @GetMapping("/user/{id}")
//    public User getUser(@PathVariable long id) {
//        User user = userService.getUserById(id);
//        if (user==null) {
//            throw new NoSuchUserException("There is no user with id " + id + " in Database");
//        }
//        return user;
//    }
//    @PostMapping("/admin")
//    public User addNewUser (@RequestBody User user,
//                            @RequestParam(value = "roles", defaultValue = "ROLE_USER") Set<String> roles) {
//        Set<Role> setRoles = roleService.getAllRoles(roles);
//        user.setRoles(setRoles);
//        userService.addUser(user);
//        return user;
//    }
//
//    @PatchMapping("/admin")
//    public User updateUser(@RequestBody User user) {
//        userService.editUser(user);
//        return user;
//    }
//
//    @DeleteMapping("/admin/{id}")
//    public String deleteUser(@PathVariable long id) {
//        User user = userService.getUserById(id);
//        if (user==null) {
//            throw new NoSuchUserException("There is no user with id " + id + "in Database");
//        }
//
//        userService.removeUser(id);
//        return "User with id " + id + "was deleted";
//    }

}
