package com.dzemiashkevich.gorodmos.entity;

import java.time.LocalDate;

public class IssueEntity {

  private String region;
  private String district;
  private LocalDate date;
  private String author;
  private String title;
  private String description;
  private String address;
  private String photoUrl;
  private int issueCode;

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhotoUrl() {
    return photoUrl;
  }

  public void setPhotoUrl(String photoUrl) {
    this.photoUrl = photoUrl;
  }

  public int getIssueCode() {
    return issueCode;
  }

  public void setIssueCode(int issueCode) {
    this.issueCode = issueCode;
  }

}
