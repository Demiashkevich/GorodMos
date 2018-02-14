package com.dzemiashkevich.gorodmos.facade;

import com.dzemiashkevich.gorodmos.action.URLFormatter;
import com.dzemiashkevich.gorodmos.entity.IssueEntity;
import com.dzemiashkevich.gorodmos.entity.Parameter;
import com.dzemiashkevich.gorodmos.parse.IssueParser;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Facade {

  private static final List<IssueEntity> allResult = new ArrayList<>();
  private static final IssueParser issueParser = new IssueParser();

  private Map<Integer, int[]> regionCodeMap = new HashMap<Integer, int[]>() {
    {
      put(1, new int[]{2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18});
      put(19, new int[]{20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32});
      put(131, new int[]{132, 133, 134, 135, 136});
      put(138, new int[]{140});
      put(33, new int[]{34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45 ,46, 47, 48, 49});
      put(50, new int[]{51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67});
      put(68, new int[]{69, 70, 71, 72, 73, 74, 75, 76});
      put(137, new int[]{141});
      put(77, new int[]{78, 79, 80, 81, 82, 83, 84, 85, 86, 87});
      put(88, new int[]{89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100});
      put(101, new int[]{102, 103, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113});
      put(114, new int[]{115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130});
    }
  };

  public void action(final Parameter formParameter) {
    Parameter urlParameter = this.parameterInit(formParameter);
    do {
      urlParameter = this.parameterInit(urlParameter);
      if (urlParameter.getZone() == 0) {
        for(int i = 0; i < regionCodeMap.size(); i++) {
          final List<Integer> keyList = new ArrayList<>(regionCodeMap.keySet());
          urlParameter.setZone(keyList.get(i));
          int[] array = regionCodeMap.get(keyList.get(i));
          for(int k = 0; k < array.length - 1; k++) {
            urlParameter.setDistinct(array[k]);
            this.execute(urlParameter);
          }
        }
      }

      if (urlParameter.getDistinct() == 0) {
        int[] array = regionCodeMap.get(urlParameter.getZone());
        for(int k = 0; k < array.length - 1; k++) {
          urlParameter.setDistinct(array[k]);
          this.execute(urlParameter);
        }
      }

      urlParameter.setFrom(formParameter.getFrom().plusMonths(1));
    } while (urlParameter.getFrom().isBefore(formParameter.getTo()) || urlParameter.getFrom().isEqual(formParameter.getTo()));
    System.out.println();
  }

  private void execute(final Parameter urlParameter) {
    final String url = URLFormatter.convert(urlParameter);
    final List<IssueEntity> result = issueParser.parse(url);
    allResult.addAll(result);
  }

  private Parameter parameterInit(final Parameter formParameter) {
    final Parameter urlParameter = new Parameter();
    final LocalDate start = formParameter.getFrom().with(TemporalAdjusters.firstDayOfMonth());
    urlParameter.setFrom(start);

    final LocalDate end = formParameter.getFrom().with(TemporalAdjusters.lastDayOfMonth());
    urlParameter.setTo(end);

    urlParameter.setFrom(urlParameter.getFrom().plusMonths(1));

    urlParameter.setDistinct(formParameter.getDistinct());
    urlParameter.setZone(formParameter.getZone());
    urlParameter.setYear(formParameter.getYear());
    return urlParameter;
  }

}
