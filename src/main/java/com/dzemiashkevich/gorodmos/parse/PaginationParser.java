package com.dzemiashkevich.gorodmos.parse;

import com.dzemiashkevich.gorodmos.parse.configuration.JsoupConnecter;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class PaginationParser {

  public int parse(final String url) {
    final Document document = JsoupConnecter.getDocumentByUrl(url);
    final Elements paginationElements = document.getElementsByClass("pagination");
    final Elements paginationPage = paginationElements.select("a");
    final String countPage = paginationPage.get(paginationPage.size() - 1).attr("data-page");
    return Integer.parseInt(countPage);
  }

}
