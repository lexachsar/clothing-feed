package com.lexach.ClothingFeed.service;

import com.lexach.ClothingFeed.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.Model;

import javax.transaction.Transactional;
import java.util.List;

public interface UserService extends UserDetailsService {

    User signupUser(User user);

    @Transactional
    User getCurrentUser();

    public void addUserToModel(Model model);

    public List<User> searchUsers(String searchTerm);

    public List<User> findUsersAndAddToModel(Model model, String searchTerm);
}
