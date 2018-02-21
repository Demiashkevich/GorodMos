package com.dzemiashkevich.gorodmos.entity.parser;

import org.jsoup.select.Elements;

public class Body {

    private Elements headerCategoryElements;
    private Elements messageListElements;

    public Elements getHeaderCategoryElements() {
        return headerCategoryElements;
    }

    public void setHeaderCategoryElements(Elements headerCategoryElements) {
        this.headerCategoryElements = headerCategoryElements;
    }

    public Elements getMessageListElements() {
        return messageListElements;
    }

    public void setMessageListElements(Elements messageListElements) {
        this.messageListElements = messageListElements;
    }

}