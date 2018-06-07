package com.lexach.ClothingFeed.service.impl;

import com.lexach.ClothingFeed.model.Product;
import com.lexach.ClothingFeed.model.User;
import com.lexach.ClothingFeed.model.UserBookmark;
import com.lexach.ClothingFeed.repository.UserBookmarkRepository;
import com.lexach.ClothingFeed.service.UserBookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
