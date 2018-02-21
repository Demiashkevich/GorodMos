package com.dzemiashkevich.gorodmos.action;

import com.dzemiashkevich.gorodmos.entity.IssueEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public final class IssueFilter {

    private IssueFilter() {
    }

    public static List<IssueEntity> filterByTime(final List<IssueEntity> issueEntities, final LocalDate from, final LocalDate to) {
        return issueEntities.stream().filter(i -> {
            if ((i.getDate().isAfter(from) || i.getDate().isEqual(from)) && (i.getDate().isBefore(to) || i.getDate().isEqual(to))) {
                return true;
            }
            return false;
        }
        ).collect(Collectors.toList());
    }

    public static List<IssueEntity> filterByCode(final List<IssueEntity> issueEntities, int code) {
        if (code == 0) {
            return issueEntities;
        }
        return issueEntities.stream().filter(i -> i.getIssueCode() == code).collect(Collectors.toList());
    }

}