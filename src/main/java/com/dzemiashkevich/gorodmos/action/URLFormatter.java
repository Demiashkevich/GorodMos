package com.dzemiashkevich.gorodmos.action;


import com.dzemiashkevich.gorodmos.entity.Parameter;

import java.time.format.DateTimeFormatter;

public final class URLFormatter {


  private URLFormatter() {
  }

  public static String convert(final Parameter parameter) {
    final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.LL.yyyy");
    final String from = parameter.getFrom().format(dateFormatter);
    final String to = parameter.getTo().format(dateFormatter);
    return "http://gorod.mos.ru/?show=problem&zone=" + parameter.getZone() + "&selected=" + parameter.getYear() + ";" + from + ";" + to + "&district=" + parameter.getDistinct() + "&page=";
  }

}
