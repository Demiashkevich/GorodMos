package com.dzemiashkevich.gorodmos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Runner extends Application {

  public static void main(String[] args) {
    launch(args);
//    Parameter requestParameter = new Parameter();
//    requestParameter.setYear(2017);
//    requestParameter.setFrom(LocalDate.of(2017, 2, 1));
//    requestParameter.setTo(LocalDate.of(2017, 4, 5));
//    requestParameter.setZone(131);
//    new Facade().action(requestParameter);
//    IssueParser issueParser = new IssueParser("http://gorod.mos.ru/?show=problem&m=12&y=2012&selected=%C4%E5%EA%E0%E1%F0%FC%202012;01.12.2012%2000:00:00;31.12.2012%2000:00:00;2012&id_theme=1&page=");
//    http://gorod.mos.ru/?show=problem&id_theme=1&m=11&y=2012&selected=%CD%EE%FF%E1%F0%FC%202012;01.11.2012%2000:00:00;30.11.2012%2000:00:00;2012
//    List<IssueEntity> parse = issueParser.parse(1, 250);
//    System.out.println();
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(Runner.class.getResource("/start_window.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
