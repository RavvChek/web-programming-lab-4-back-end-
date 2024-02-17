package ru.ravvcheck.labweb4.user;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {
    @Autowired
    private final UserService userService;

    @CrossOrigin
    @PostMapping("/api/register")
    public void register(@RequestParam("login") String login,
                         @RequestParam("password") String password) {
        userService.registerUser(login, password);
    }

    @CrossOrigin
    @PostMapping("/api/login")
    public void login(@RequestHeader("Authorization") String authorization) {
        userService.loginUser(authorization);
    }
}
