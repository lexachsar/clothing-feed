package com.lexach.clothing.feed.repository;

import com.lexach.clothing.feed.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

    User findByEmail(String email);

    List<User> findDistinctByUsernameOrEmail(String login, String email);

}