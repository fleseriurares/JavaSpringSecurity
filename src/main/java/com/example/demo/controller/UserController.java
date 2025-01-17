package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    @GetMapping("/users")
    public String getUsers(Model model){
        List<UserDto> userDtos = userService.getAllUsers();
        model.addAttribute("title", "Users");
        model.addAttribute("users", userDtos);
        return "users";
    }

    @GetMapping("/users/{id}")
    public UserDto getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @GetMapping("/users/create")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public String displayCreateUserForm(Model model) {
        model.addAttribute("title", "Create User");
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.findAll());
        return "createUser";
    }

    @PostMapping("/users/create")
   // @PreAuthorize("hasAuthority('ADMIN')")
    public String processCreateUserForm(@ModelAttribute User user) {
        userService.createUser(user);
        return "redirect:/users";
    }


    @GetMapping("/users/delete")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public String displayDeleteUserForm(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("title", "Delete User");
        model.addAttribute("users", users);
        return "deleteUser";
    }

    @PostMapping("/users/delete/{id}")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public String processDeleteUserForm(@PathVariable Integer id) {
        System.out.println("Saluut");
        userService.deleteUserById(id);
        return "redirect:/users";
    }


}
