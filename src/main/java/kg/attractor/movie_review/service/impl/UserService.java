package kg.attractor.movie_review.service.impl;

import kg.attractor.movie_review.dto.UserDto;
import kg.attractor.movie_review.exception.UserNotFoundException;
import kg.attractor.movie_review.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<UserDto> getUsers();


    UserDto getUserById(int id) throws UserNotFoundException;

    void createUser(UserDto user);
}
