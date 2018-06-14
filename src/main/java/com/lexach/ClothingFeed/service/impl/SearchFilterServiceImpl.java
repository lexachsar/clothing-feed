package com.lexach.ClothingFeed.service.impl;

import com.lexach.ClothingFeed.controller.form.SearchFilterForm;
import com.lexach.ClothingFeed.model.*;
import com.lexach.ClothingFeed.repository.*;
import com.lexach.ClothingFeed.service.SearchFilterService;
import com.lexach.ClothingFeed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service
public class SearchFilterServiceImpl implements SearchFilterService {

    @Autowired
    private SearchFilterRepository searchFilterRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ColourRepository colourRepository;

    @Autowired
    private UserService userService;

    @Override
    public SearchFilter createSearchFilterFromForm(SearchFilterForm searchFilterForm) {

        SearchFilter result = new SearchFilter();

        // Set user field
        User user = userService.getCurrentUser();
        result.setUser(user);

        // Set category field
        if (!Objects.isNull(searchFilterForm.getCategoryTerm())) {
            Iterable<ProductCategory> allCategories = productCategoryRepository.findAll();

            for (ProductCategory category : allCategories) {
                if (category.getName().contains(searchFilterForm.getCategoryTerm())) {
                    result.setCategory(category);
                }
            }
        }

        // Set colour field
        if (!Objects.isNull(searchFilterForm.getColourTerm())) {
            Iterable<Colour> allColours = colourRepository.findAll();

            for (Colour colour : allColours) {
                if (colour.getName().contains(searchFilterForm.getColourTerm()) ||
                        colour.getHex().equals(searchFilterForm.getColourTerm())) {
                    result.setColour(colour);
                }
            }

        }


        // TODO: Set category size field

        // Set gender field
        if (!Objects.isNull(searchFilterForm.getGenderTerm())) {
            Iterable<Gender> allGenders = genderRepository.findAll();

            for (Gender gender : allGenders) {
                if (gender.getName().contains(searchFilterForm.getGenderTerm())) {
                    result.setGender(gender);
                }
            }

        }


        // TODO add logic for all other fields of SearchFilterForm.


        return result;

    }

    @Override
    public SearchFilter save(SearchFilter searchFilter) {
        return searchFilterRepository.save(searchFilter);
    }

    @Override
    public List<Product> applySearchFilter(SearchFilter searchFilter) {

        List<Product> result = new LinkedList<>();

        // TODO: replace with sql query
        if (Objects.isNull(searchFilter.getCategory())) {
            if (!Objects.isNull(searchFilter.getGender())) {
                result = productRepository.findByGenderOrderByCreatedAt(searchFilter.getGender());
            }
        } else if (Objects.isNull(searchFilter.getGender())) {
            if (!Objects.isNull(searchFilter.getCategory())) {
                result = productRepository.findByCategoryOrderByCreatedAt(searchFilter.getCategory());
            }
        } else {
            result = productRepository.findDistinctByCategoryOrGenderOrderByCreatedAt(searchFilter.getCategory(), searchFilter.getGender());
        }

        if (result.isEmpty()) {
            return null;
        } else {
            return result;
        }

        // TODO add other fields finding


    }

    @Override
    public List<SearchFilter> findByUser(User user) {
        return searchFilterRepository.findByUser(user);
    }
}
