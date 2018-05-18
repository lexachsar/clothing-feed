package com.lexach.ClothingFeed.parsers;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class WildberriesParser extends AbstractParser {

    WildberriesParser() {
        super("https://www.wildberries.ru");

        this.menCategory = "https://www.wildberries.ru/catalog/muzhchinam/odezhda";
        this.womenCategory = "https://www.wildberries.ru/catalog/zhenshchinam/odezhda";
        this.childrenCategory = "https://www.wildberries.ru/catalog/detyam/odezhda";
    }


    @Override
    public Elements parseRoot() {

    }

    @Override
    public Elements parseCategory(Document categoryDoc) {
        // Create Elements collection with all products from this page.
        Elements products = categoryDoc.getElementsByClass("catalog-prev-link");

    }

    @Override
    public Elements parseProduct() {

    }
}
