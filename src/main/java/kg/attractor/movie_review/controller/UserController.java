package kg.attractor.movie_review.controller;

import kg.attractor.movie_review.dto.UserDto;
import kg.attractor.movie_review.exception.UserNotFoundException;
import kg.attractor.movie_review.service.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("users")
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("users/{id}") //http://localhost:9889/users/1/profile
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        try{
            UserDto userDto = userService.getUserById(id);
            return ResponseEntity.ok(userDto);
        } catch (UserNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("users")
    public HttpStatus createUser(UserDto user) {
        userService.createUser(user);
        return HttpStatus.OK;
    }
}
