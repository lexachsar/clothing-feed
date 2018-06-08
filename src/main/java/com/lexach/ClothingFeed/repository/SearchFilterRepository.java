package com.lexach.ClothingFeed.repository;

import com.lexach.ClothingFeed.model.SearchFilter;
import com.lexach.ClothingFeed.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SearchFilterRepository extends CrudRepository<SearchFilter, Long> {

    List<SearchFilter> findByUser(User user);

}
