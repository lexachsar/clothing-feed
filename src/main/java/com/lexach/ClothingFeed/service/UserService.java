package com.lexach.ClothingFeed.service;

import com.lexach.ClothingFeed.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User signupUser(User user);

}
