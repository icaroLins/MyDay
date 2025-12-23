package Task.MyDay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Task.MyDay.login.LoginRequest;
import Task.MyDay.login.LoginResponse;
import Task.MyDay.model.User;
import Task.MyDay.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid User user) {
        try {
            User newUser = userService.regiter(user);

            return ResponseEntity.ok(newUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/logar")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            LoginResponse valida = userService.validatorLogin(request);
            return ResponseEntity.ok(valida);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/me")
    public ResponseEntity<?> me(Authentication authentication) {

        String email = authentication.getName();

        User user = userService.searchByEmail(email);

        return ResponseEntity.ok(user);
    }

}
