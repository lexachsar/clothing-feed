package com.lexach.ClothingFeed.exception;

import java.util.logging.Logger;

/**
 * Exception for bad links.
 */
public class LinkIsNotValidException extends Exception {
    private String link;

    public LinkIsNotValidException(String link){
        // Format error message.
        super(String.format("This ", link, " link is not valid."));
    }

    public String getLink() {
        return link;
    }

}
