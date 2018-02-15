package com.dzemiashkevich.gorodmos.action;

import com.dzemiashkevich.gorodmos.entity.IssueEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public final class IssueFilter {

  private IssueFilter() {
  }

  public static List<IssueEntity> filterByTime(final List<IssueEntity> issueEntities, final LocalDate from, final LocalDate to) {
    return issueEntities.stream().filter(i ->
      i.getDate().isAfter(from) && i.getDate().isBefore(to)
    ).collect(Collectors.toList());
  }

}
