package com.lexach.clothing.feed.service;

import com.lexach.clothing.feed.model.Product;
import com.lexach.clothing.feed.model.User;
import com.lexach.clothing.feed.model.UserBookmark;

import java.util.List;

public interface UserBookmarkService {

    public UserBookmark save(UserBookmark userBookmark);

    public void delete(UserBookmark userBookmark);

    public UserBookmark findByUserAndProduct(User user, Product product);

    public List<UserBookmark> findByUser(User user);
}
