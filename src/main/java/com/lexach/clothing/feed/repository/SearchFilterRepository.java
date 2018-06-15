package com.lexach.clothing.feed.repository;

import com.lexach.clothing.feed.model.SearchFilter;
import com.lexach.clothing.feed.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SearchFilterRepository extends CrudRepository<SearchFilter, Long> {

    List<SearchFilter> findByUser(User user);

}
