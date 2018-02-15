package com.dzemiashkevich.gorodmos.builder;

import com.dzemiashkevich.gorodmos.entity.IssueEntity;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.Locale;

public class IssueEntityBuilder {

  private IssueEntity issueEntity = new IssueEntity();

  public IssueEntity build(){
    return issueEntity;
  }

  public void setDate(String strWithDate) {
    if (strWithDate == null || strWithDate.isEmpty()) {
      return;
    }
    final String[] strWithDateArray = strWithDate.split(" ");
    final String day = strWithDateArray[1];
    final String month = strWithDateArray[2];
    final String year = strWithDateArray[3];

    final String date = day + " " + month + " " + year;

    final LocalDate localDate = this.parseStringToLocalDate(date);
    issueEntity.setDate(localDate);
  }

  public void setAuthor(String author) {
    issueEntity.setAuthor(author);
  }

  public void setTitle(String title) {
    issueEntity.setTitle(title);
  }

  public void setDescription(String description) {
    issueEntity.setDescription(description);
  }

  public void setAddress(String address) {
    issueEntity.setAddress(address);
  }

  public void setPhotoUrl(String photoUrl) {
    issueEntity.setPhotoUrl(photoUrl);
  }

  public void setRegionAndDistrict(String regionAndDistrict) {
    if (regionAndDistrict == null || regionAndDistrict.isEmpty()) {
      return;
    }
    final String[] regionAndDistrictArray = regionAndDistrict.split("—");
    if (regionAndDistrictArray.length != 2) {
      return;
    }
    final String district = regionAndDistrictArray[0];
    final String region = regionAndDistrictArray[1];

    issueEntity.setDistrict(district);
    issueEntity.setRegion(region);
  }

  public void setFigure(String figure) {
    if (figure == null || figure.isEmpty()) {
      return;
    }
    final String[] split = figure.split("-");
    if (split.length != 2) {
      return;
    }
    final String codeStr = split[1];
    issueEntity.setIssueCode(Integer.parseInt(codeStr));
  }

  private LocalDate parseStringToLocalDate(final String date) {
    final SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", russianDateFormatSymbols);
    try {
      Date parse = dateFormat.parse(date);
      return parse.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return null;
  }

  private static DateFormatSymbols russianDateFormatSymbols = new DateFormatSymbols(){

    @Override
    public String[] getMonths() {
      return new String[]{"Января", "Февраля", "Марта", "Апреля", "Мая", "Июня",
          "Июля", "Августа", "Сентября", "Октября", "Ноября", "Декабря"};
    }

  };
}
