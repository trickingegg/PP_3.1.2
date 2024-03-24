package ru.bogatyryov.springbootapp.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.bogatyryov.springbootapp.model.User;
import ru.bogatyryov.springbootapp.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        model.addAttribute("user", new User());
        return "users";
    }

    @GetMapping("/addUser")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") @Valid User user,
                          BindingResult result) {
        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
            return "addUser";
        }
        userService.add(user);
        return "redirect:/users";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") long id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/editUser")
    public String editUserForm(@RequestParam("id") long id, Model model) {
        User existingUser = userService.findById(id);
        model.addAttribute("user", existingUser);
        return "editUser";
    }

    @PostMapping("/editUser")
    public String updateUser(@ModelAttribute("user") @Valid User user,
                             BindingResult result,
                             @RequestParam("id") long id) {
        if (result.hasErrors()) {
            user.setId(id);
            return "editUser";
        }
        userService.update(user);
        return "redirect:/users";
    }
}
