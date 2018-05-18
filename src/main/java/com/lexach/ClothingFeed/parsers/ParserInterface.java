package com.lexach.ClothingFeed.parsers;

import org.jsoup.select.Elements;

public interface ParserInterface {

    Elements parseRoot();

    Elements parseCategory(String categoryLink);

    Elements parseProduct();


}
