package com.dzemiashkevich.gorodmos.parse;

import com.dzemiashkevich.gorodmos.builder.IssueEntityBuilder;
import com.dzemiashkevich.gorodmos.entity.IssueEntity;
import com.dzemiashkevich.gorodmos.entity.parser.Body;
import com.dzemiashkevich.gorodmos.parse.configuration.JsoupConnecter;
import org.apache.commons.collections4.CollectionUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class IssueParser {

  public List<IssueEntity> parse(final String url, int from, int to) {
    List<IssueEntity> allIssueList = new ArrayList<>();

    for(int i = from; i <= to; i++) {
      final String currentUrl = url + i;

      final List<IssueEntity> issueList = this.parsePage(currentUrl);
      if (CollectionUtils.isNotEmpty(issueList)) {
        allIssueList.addAll(issueList);
        System.out.println(i);
      }
    }

    return allIssueList;
  }

  private List<IssueEntity> parsePage(final String currentURL) {
    Document document = JsoupConnecter.getDocumentByUrl(currentURL);
    Body body = this.parseBody(document);

    if (body.getHeaderCategoryElements().size() != body.getMessageListElements().size()) {
      findBodyWithoutHeader(body);
    }

    final List<IssueEntity> issuePage = new ArrayList<>();

    for(int count = 0; count < body.getHeaderCategoryElements().size(); count++) {
      final IssueEntityBuilder issueBuilder = new IssueEntityBuilder();

      final Element hElement = body.getHeaderCategoryElements().get(count);
      this.parseHeader(issueBuilder, hElement);

      final Element mElement = body.getMessageListElements().get(count);
      this.parseMessage(issueBuilder, mElement);

      issuePage.add(issueBuilder.build());
    }
    return issuePage;
  }

  private void findBodyWithoutHeader(final Body body) {
    for (int i = 0; i < body.getMessageListElements().size() - 1; i++) {
      final Element nextElement = body.getMessageListElements().get(i).nextElementSibling();
      if (!nextElement.hasClass("headerCategory")) {
        body.getHeaderCategoryElements().add(i + 1, createHeaderElement());
      }
      if (body.getHeaderCategoryElements().size() == body.getMessageListElements().size()) {
        return;
      }
    }

    if (body.getHeaderCategoryElements().size() != body.getMessageListElements().size()) {
      body.getHeaderCategoryElements().add(0, createHeaderElement());
    }

  }

  private Element createHeaderElement() {
    Element element = new Element(Tag.valueOf("div"), "");
    element.addClass("headerCategory");
    element.appendElement("div").addClass("green");
    element.appendElement("div").addClass("remark");
    element.appendElement("div").addClass("figure");
    return element;
  }

  private Body parseBody(final Document document) {
    final Elements headerCategoryElements = document.getElementsByClass("headerCategory");
    final Elements messageListElements = document.getElementsByClass("mes-list");

    final Body body = new Body();
    body.setHeaderCategoryElements(headerCategoryElements);
    body.setMessageListElements(messageListElements);
    return body;
  }

  private void parseHeader(final IssueEntityBuilder issueBuilder, final Element hElement) {
    final Elements addressElement = hElement.getElementsByClass("green");
    issueBuilder.setAddress(addressElement.html());

    final Elements regionAndDistrictElement = hElement.getElementsByClass("remark");
    issueBuilder.setRegionAndDistrict(regionAndDistrictElement.html());

    final Elements figureElement = hElement.getElementsByClass("figure");
    issueBuilder.setFigure(figureElement.attr("class"));
  }

  private void parseMessage(final IssueEntityBuilder issueBuilder, final Element mElement) {
    final Elements dateElement = mElement.getElementsByClass("m-date");
    issueBuilder.setDate(dateElement.html());

    final Elements authorElement = mElement.getElementsByClass("m-name");
    issueBuilder.setAuthor(authorElement.select("a").html());

    final Elements titleElement = mElement.getElementsByClass("themeText");
    issueBuilder.setTitle(titleElement.html());

    final Elements descriptionElement = mElement.getElementsByClass("messageText").select("p");
    issueBuilder.setDescription(descriptionElement.html());

    final Elements imgElement = mElement.getElementsByClass("img-mes-bg");
    issueBuilder.setPhotoUrl(imgElement.attr("original"));
  }

}