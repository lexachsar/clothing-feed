package com.lexach.ClothingFeed.repository;

import com.lexach.ClothingFeed.model.Product;
import com.lexach.ClothingFeed.model.User;
import com.lexach.ClothingFeed.model.UserBookmark;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserBookmarkRepository extends CrudRepository<UserBookmark, Long> {

    UserBookmark findByUserAndProduct(User user, Product product);

    List<UserBookmark> findByUser(User user);

}