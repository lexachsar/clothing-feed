package com.lexach.ClothingFeed.service;

import com.lexach.ClothingFeed.controller.form.SearchFilterForm;
import com.lexach.ClothingFeed.model.Product;
import com.lexach.ClothingFeed.model.SearchFilter;
import com.lexach.ClothingFeed.model.User;

import java.util.List;

public interface SearchFilterService {

    public SearchFilter createSearchFilterFromForm(SearchFilterForm searchFilterForm);

    /**
     * Saves @param searchFilter @return this entity
     */
    public SearchFilter save(SearchFilter searchFilter);

    /**
     * Apply search filter and find all products for it.
     * @param searchFilter given search filter.
     * @return List of founded products
     */
    public List<Product> applySearchFilter(SearchFilter searchFilter);

    /**
     * Find all SearchFilters, that owned by @param user.
     * @return all search filter of @param user.
     */
    public List<SearchFilter> findByUser(User user);

}
