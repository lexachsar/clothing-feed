package com.lexach.ClothingFeed.controller.form;

public class SearchForm {

    private String searchTerm;

    public SearchForm() {
    }

    public SearchForm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }
}
