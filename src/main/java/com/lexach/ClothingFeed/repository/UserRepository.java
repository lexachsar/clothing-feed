package com.lexach.ClothingFeed.repository;

import com.lexach.ClothingFeed.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
