package com.lexach.ClothingFeed.service.impl;

import com.lexach.ClothingFeed.model.User;
import com.lexach.ClothingFeed.model.UserBookmark;
import com.lexach.ClothingFeed.repository.UserRepository;
import com.lexach.ClothingFeed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("Can't find user with username " + username);
        }
        return user;

    }

    @Override
    public User signupUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);

    }

    @Override
    public User getCurrentUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().
                getAuthentication().getPrincipal();

        User user = null;
        if (userDetails instanceof User) {
            user =  (User) userDetails;
        }

        return user;
    }

    @Override
    public void addUserToModel(Model model) {
        User user = getCurrentUser();

        model.addAttribute("user", user);
    }

    @Override
    public List<User> searchUsers(String searchTerm) {
        return userRepository.findDistinctByUsernameOrEmail(searchTerm, searchTerm);
    }

    @Override
    public List<User> findUsersAndAddToModel(Model model, String searchTerm) {
        List<User> users = this.searchUsers(searchTerm);

        if(users.size() > 0 ) {

            List<User> resultUsers;

            if(users.size() < 4) {
                resultUsers = users;
            } else {
                resultUsers = users.subList(0, 4);
            }

            model.addAttribute("users", resultUsers);

            return resultUsers;
        } else {
            return null;
        }
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
