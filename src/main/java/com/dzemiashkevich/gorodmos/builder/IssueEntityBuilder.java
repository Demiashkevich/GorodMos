package com.dzemiashkevich.gorodmos.builder;

import com.dzemiashkevich.gorodmos.entity.IssueEntity;

import java.time.LocalDate;

public class IssueEntityBuilder {

  private IssueEntity issueEntity = new IssueEntity();

  public IssueEntity build(){
    return issueEntity;
  }

  public void setRegion(String region) {
    issueEntity.setRegion(region);
  }

  public void setDistrict(String district) {
    issueEntity.setDistrict(district);
  }

  public void setDate(String date) {
//    issueEntity.setDate(date);
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

  }

  public void setFigure(String figure) {
  }
}
