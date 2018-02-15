package com.dzemiashkevich.gorodmos.entity;

import java.time.LocalDate;

public class Parameter {

  private int zone;
  private int distinct;
  private int year;
  private int month;
  private LocalDate from;
  private LocalDate to;
  private int issueCode;

  public int getZone() {
    return zone;
  }

  public void setZone(int zone) {
    this.zone = zone;
  }

  public int getDistinct() {
    return distinct;
  }

  public void setDistinct(int distinct) {
    this.distinct = distinct;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public LocalDate getFrom() {
    return from;
  }

  public void setFrom(LocalDate from) {
    this.from = from;
  }

  public LocalDate getTo() {
    return to;
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public void setTo(LocalDate to) {
    this.to = to;
  }

  public int getIssueCode() {
    return issueCode;
  }

  public void setIssueCode(int issueCode) {
    this.issueCode = issueCode;
  }

}
