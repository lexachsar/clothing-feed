package com.lexach.clothing.feed.controller.form;

public class SearchFilterForm {

    private String categoryTerm;

    private String colourTerm;

    private String sizeTerm;

    private String genderTerm;

    public String getCategoryTerm() {
        return categoryTerm;
    }

    public void setCategoryTerm(String categoryTerm) {
        this.categoryTerm = categoryTerm;
    }

    public String getColourTerm() {
        return colourTerm;
    }

    public void setColourTerm(String colourTerm) {
        this.colourTerm = colourTerm;
    }


    public String getGenderTerm() {
        return genderTerm;
    }

    public void setGenderTerm(String genderTerm) {
        this.genderTerm = genderTerm;
    }

    public String getSizeTerm() {
        return sizeTerm;
    }

    public void setSizeTerm(String sizeTerm) {
        this.sizeTerm = sizeTerm;
    }
}
