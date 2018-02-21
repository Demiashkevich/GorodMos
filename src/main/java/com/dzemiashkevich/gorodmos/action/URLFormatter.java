package com.dzemiashkevich.gorodmos.action;


import com.dzemiashkevich.gorodmos.entity.Parameter;

import java.time.format.DateTimeFormatter;

public final class URLFormatter {


    private URLFormatter() {
    }

    public static String formation(final Parameter parameter) {
        final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.LL.yyyy");
        final String from = parameter.getFrom().format(dateFormatter);
        final String to = parameter.getTo().format(dateFormatter);
        return "http://gorod.mos.ru/?show=problem&zone=" + parameter.getZone() + "&y=" + parameter.getYear() + "&m=" + parameter.getMonth() + "&selected=" + parameter.getYear() + ";" + from + ";" + to + "&district=" + parameter.getDistinct();
    }

    public static String formationWithPage(final Parameter parameter) {
        final String url = formation(parameter);
        return url + "&page=";
    }

}