package com.lexach.ClothingFeed.service;

import com.lexach.ClothingFeed.model.Product;
import com.lexach.ClothingFeed.model.User;
import com.lexach.ClothingFeed.model.UserBookmark;

import java.util.List;

public interface UserBookmarkService {

    public UserBookmark save(UserBookmark userBookmark);

    public void delete(UserBookmark userBookmark);

    public UserBookmark findByUserAndProduct(User user, Product product);

    public List<UserBookmark> findByUser(User user);
}
