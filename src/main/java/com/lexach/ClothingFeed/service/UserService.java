package com.lexach.ClothingFeed.service;

import com.lexach.ClothingFeed.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User signupUser(User user);

    // TODO add find by email method implementation.
    // User findByEmail(String email);

    // TODO add find by nickname method implementation.
    // User findByNickname(String nickname);

}
