package com.lexach.ClothingFeed.service;

import com.lexach.ClothingFeed.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.Model;

public interface UserService extends UserDetailsService {

    User signupUser(User user);

    User getCurrentUser();

    public void addUserToModel(Model model);
}
