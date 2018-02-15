package com.dzemiashkevich.gorodmos.action;

import com.dzemiashkevich.gorodmos.entity.IssueEntity;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public final class ExcelWriter {

  private static String[] columnHeader = {"Область", "Район", "Дата создания", "Автор", "Тема", "Описание", "Адрес", "Фото", "Проблема"};

  private String url;

  public ExcelWriter(final String url) {
    this.url = url;
  }

  public void writeIssue(final List<IssueEntity> issueEntities) {
    final XSSFWorkbook workbook = new XSSFWorkbook();
    final XSSFSheet sheet = workbook.createSheet("Moscow issue");

    this.createHeader(sheet, workbook);
    this.createIssueData(issueEntities, sheet);
    this.autoSize(sheet);
    this.writeToExcel(workbook);
  }

  private void autoSize(final XSSFSheet sheet) {
    for(int i = 0; i < columnHeader.length; i++) {
      sheet.autoSizeColumn(i);
    }
  }

  private void writeToExcel(final XSSFWorkbook workbook) {
    try {
      FileOutputStream fileOut = new FileOutputStream(url);
      workbook.write(fileOut);
      fileOut.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void createIssueData(final List<IssueEntity> issueEntities, final XSSFSheet sheet) {
    int rowNum = 1;
    for(IssueEntity issueEntity: issueEntities) {
      final Row row = sheet.createRow(rowNum++);

      row.createCell(0).setCellValue(issueEntity.getRegion());
      row.createCell(1).setCellValue(issueEntity.getDistrict());
      row.createCell(2).setCellValue(issueEntity.getDate().toString());
      row.createCell(3).setCellValue(issueEntity.getAuthor());
      row.createCell(4).setCellValue(issueEntity.getTitle());
      row.createCell(5).setCellValue(issueEntity.getDescription());
      row.createCell(6).setCellValue(issueEntity.getAddress());
      row.createCell(7).setCellValue(issueEntity.getPhotoUrl());
      row.createCell(8).setCellValue(issueEntity.getIssueCode());
    }
  }

  private void createHeader(final XSSFSheet sheet, final XSSFWorkbook workbook) {
    Row headerRow = sheet.createRow(0);

    for(int i = 0; i < columnHeader.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columnHeader[i]);
      cell.setCellStyle(createHeaderCellStyle(workbook));
    }
  }

  private CellStyle createHeaderCellStyle(final XSSFWorkbook workbook) {
    final CellStyle headerCellStyle = workbook.createCellStyle();
    final Font headerFont = this.headerStyleInit(workbook);
    headerCellStyle.setFont(headerFont);
    return headerCellStyle;
  }

  private Font headerStyleInit(final XSSFWorkbook workbook) {
    Font headerFont = workbook.createFont();
    headerFont.setBold(true);
    headerFont.setFontHeightInPoints((short) 14);
    return headerFont;
  }

}
