package com.lexach.clothing.feed.service.impl;

import com.lexach.clothing.feed.model.Product;
import com.lexach.clothing.feed.model.User;
import com.lexach.clothing.feed.model.UserBookmark;
import com.lexach.clothing.feed.repository.UserBookmarkRepository;
import com.lexach.clothing.feed.service.UserBookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBookmarkServiceImpl implements UserBookmarkService {

    @Autowired
    private UserBookmarkRepository userBookmarkRepository;

    @Override
    public UserBookmark save(UserBookmark userBookmark) {
        return userBookmarkRepository.save(userBookmark);
    }

    @Override
    public void delete(UserBookmark userBookmark) {
        userBookmarkRepository.delete(userBookmark);
    }

    @Override
    public UserBookmark findByUserAndProduct(User user, Product product) {
        return userBookmarkRepository.findByUserAndProduct(user, product);
    }

    @Override
    public List<UserBookmark> findByUser(User user) {
        return userBookmarkRepository.findByUser(user);
    }


}
