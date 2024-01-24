package ru.sberbank.jd.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.sberbank.jd.security.model.User;
import ru.sberbank.jd.security.security.model.AppAuthentication;

@RestController
@Slf4j
public class UserController {

    @GetMapping("/users/{id}")
    public String getUser(@PathVariable("id") String id) {
        AppAuthentication authentication = (AppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        log.info("login={}; roles={}", authentication.getLogin(), authentication.getRoles());
        return "User1";
    }

    @PostAuthorize("hasRole('ADMIN')")
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return user;
    }

}
