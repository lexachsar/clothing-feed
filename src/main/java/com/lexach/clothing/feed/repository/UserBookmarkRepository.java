package com.lexach.clothing.feed.repository;

import com.lexach.clothing.feed.model.Product;
import com.lexach.clothing.feed.model.User;
import com.lexach.clothing.feed.model.UserBookmark;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserBookmarkRepository extends CrudRepository<UserBookmark, Long> {

    UserBookmark findByUserAndProduct(User user, Product product);

    List<UserBookmark> findByUser(User user);

}
