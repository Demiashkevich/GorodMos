package com.dzemiashkevich.gorodmos;

import com.dzemiashkevich.gorodmos.entity.Parameter;
import com.dzemiashkevich.gorodmos.facade.Facade;

import java.time.LocalDate;

public class Runner {

  private final static int ВОСТОЧНЫЙ_ОКРУГ = 1;
  private final static int БОГОРОДСКОЕ = 2;
  private final static int ВЕШНЯКИ = 3;
  private final static int ВОСТОЧНОЕ_ИЗМАЙЛОВО = 4;
  private final static int ВОСТОЧНЫЙ = 6;
  private final static int ГОЛЬЯНОВО = 7;
  private final static int ИВАНОВСКОЕ = 8;
  private final static int ИЗМАЙЛОВО = 9;
  private final static int КОСИНО_УХТОМСКИЙ = 10;
  private final static int МЕТРОГОРОДОК = 11;
  private final static int НОВОГИРЕЕВО = 12;
  private final static int НОВОКОСИНО = 13;
  private final static int ПЕТРОВО = 14;
  private final static int ПРЕОБРАЖЕНСКОЕ = 15;
  private final static int СЕВЕРНОЕ_ИЗМАЙЛОВО = 16;
  private final static int СОКОЛИНАЯ_ГОРА = 17;
  private final static int СОКОЛЬНИКИ = 18;

  private final static int ЗАПАДНЫЙ_ОКРУГ = 19;
  private final static int ВНУКОВО = 20;
  private final static int ДОРОГОМИЛОВО = 21;
  private final static int КРЫЛАТСКОЕ = 22;
  private final static int КУНЦЕВО = 23;
  private final static int МОЖАЙСКИЙ = 24;
  private final static int НОВО_ПЕРЕДЕЛКИНО = 25;
  private final static int ОЧАКОВО_МАТВЕЕВСКОЕ = 26;
  private final static int ПРОСПЕКТ_ВЕРНАДСКОГО = 27;
  private final static int РАМЕНКИ = 28;
  private final static int СОЛНЦЕВО = 29;
  private final static int ТРОПАРЕВО_НИКУЛЕНО = 30;
  private final static int ФИЛЕВСКИЙ_ПАРК = 31;
  private final static int ФИЛИ_ДАВЫДКОВО = 32;

  private final static int ЗЕЛЕНОГРАДСКИЙ_ОКРУГ = 131;
  private final static int КРЮКОВО = 132;
  private final static int МАТУШКИНО = 133;
  private final static int САВЕЛКИ = 134;
  private final static int СИЛИНО = 135;
  private final static int СТАРОЕ_КРЮКОВО = 136;

  private final static int НОВОМОСКОВСКИЙ_ОКРУГ = 138;
  private final static int ЩЕРБИНКА = 140;

  private final static int СЕРВЕРНЫЙ_ОКРУГ = 33;
  private final static int АЭРОПОРТ = 34;
  private final static int БЕГОВОЙ = 35;
  private final static int БЕСКУДНИКОВСКИЙ = 36;
  private final static int ВОЙКОВСКИЙ = 37;
  private final static int ВОСТОЧНОЕ_ДЕГУНИНО = 38;
  private final static int ГОЛОВИНСКИЙ = 39;
  private final static int ДМИТРОВСКИЙ = 40;
  private final static int ЗАПАДНОЕ_ДЕГУНИНО = 41;
  private final static int КОПТЕВО = 42;
  private final static int ЛЕВОБЕРЕЖНЫЙ = 43;
  private final static int МОЛЖАНИНОВСКИЙ = 44;
  private final static int САВЕЛОВСКИЙ = 45;
  private final static int СОКОЛ = 46;
  private final static int ТИМИРЯЗЕВСКИЙ = 47;
  private final static int ХОВРИНО = 48;
  private final static int ХОРОШЕВСКИЙ = 49;

  private final static int СЕВЕРО_ВОСТОЧНЫЙ_ОКРУГ = 50;
  private final static int АЛЕКСЕЕВСКИЙ = 51;
  private final static int АЛТУФЬЕВСКИЙ = 52;
  private final static int БАБУШКИНСКИЙ = 53;
  private final static int БИБЕРЕВО = 54;
  private final static int БУТЫРСКИЙ = 55;
  private final static int ЛИАНОЗОВО = 56;
  private final static int ЛОСИНООСТРОВСКИЙ = 57;
  private final static int МАРФИНО = 58;
  private final static int МАРЬИНА_РОЩА = 59;
  private final static int ОСТАНКИНСКИЙ = 60;
  private final static int ОТРАДНОЕ = 61;
  private final static int РОСТОКИНО = 62;
  private final static int СВИБЛОВО = 63;
  private final static int СЕВЕРНОЕ_МЕДВЕДКИНО = 64;
  private final static int СЕВЕРНЫЙ = 65;
  private final static int ЮЖНОЕ_МЕДВЕДКОВО = 66;
  private final static int ЯРОСЛАВСКИЙ = 67;

  private final static int СЕВЕРО_ЗАПАДНЫЙ_ОКРУГ = 68;
  private final static int КУРКИНО = 69;
  private final static int МИТИНО = 70;
  private final static int ПОКРОВСКОЕ_СТРЕШНЕВО = 71;
  private final static int СЕВЕРНОЕ_ТУШИНО = 72;
  private final static int СТРОГИНО = 73;
  private final static int ХОРОШЕВО_МНЕВНИКИ = 74;
  private final static int ЩУКИНО = 75;
  private final static int ЮЖНОЕ_ТУШИНО = 76;

  private final static int ТРОИЦКИЙ_ОКРУГ = 137;
  private final static int ТРОИЦК = 141;

  private final static int ЦЕНТРАЛЬНЫЙ_ОКРУГ = 77;
  private final static int АРБАТ = 78;
  private final static int БАСМАННЫЙ = 79;
  private final static int ЗАМОСКВОРЕЧЬЕ = 80;
  private final static int КРАСНОСЕЛЬСКИЙ = 81;
  private final static int МЕЩАНСКИЙ = 82;
  private final static int ПРЕСНЕНСКИЙ = 83;
  private final static int ТАГАНСКИЙ = 84;
  private final static int ТВЕРСКОЙ = 85;
  private final static int ХАМОВНИКИ = 86;
  private final static int ЯКИМАНКА = 87;

  private final static int ЮГО_ВОСТОЧНЫЙ_ОКРУГ = 88;
  private final static int ВЫХИНО_ЖУЛЕБИНО = 89;
  private final static int КАПОТНЯ = 90;
  private final static int КУЗЬМИНКИ = 91;
  private final static int ЛЕФОРТОВО = 92;
  private final static int ЛЮБЛИНО = 93;
  private final static int МАРЬИНО = 94;
  private final static int НЕКРАСОВКА = 95;
  private final static int НИЖЕГОРОДСКИЙ = 96;
  private final static int ПЕЧАТНИКИ = 97;
  private final static int РЯЗАНСКИЙ = 98;
  private final static int ТЕКСТИЛЬЩИКИ = 99;
  private final static int ЮЖНОПОРТОВЫЙ = 100;

  private final static int ЮГО_ЗАПАДНЫЙ_ОКРУГ = 101;
  private final static int АКАДЕМИЧЕСКИЙ = 102;
  private final static int ГАГАРИНСКИЙ = 103;
  private final static int ЗЮЗИНО = 104;
  private final static int КОНЬКОВО = 105;
  private final static int КОТЛОВКА = 106;
  private final static int ЛОМОНОСОВСКИЙ = 107;
  private final static int ОБРУЧЕВСКИЙ = 108;
  private final static int СЕВЕРНОЕ_БУТЛОВО = 109;
  private final static int ТЕПЛЫЙ_СТАН = 110;
  private final static int ЧЕРЕМУШКИ = 111;
  private final static int ЮЖНОЕ_БУТЛОВО = 112;
  private final static int ЯСЕНЕВО = 113;

  private final static int ЮЖНЫЙ_ОКРУГ = 114;
  private final static int БИРЮЛЕВО_ВОСТОЧНОЕ = 115;
  private final static int БИРЮЛЕВО_ЗАПАДНОЕ = 116;
  private final static int БРАТЕЕВО = 117;
  private final static int ДАНИЛОВСКИЙ = 118;
  private final static int ДОНСКОЙ = 119;
  private final static int ЗЯБЛИКОВО = 120;
  private final static int МОСКВОРЕЧЬЕ_САБУРОВО = 121;
  private final static int НАГАТИНО_САДОВНИКИ = 122;
  private final static int НАГАТИНСКИЙ_ЗАТОН = 123;
  private final static int НАГОРНЫЙ = 124;
  private final static int ОРЕХОВО_БОРИСОВО_СЕВЕРНОЕ = 125;
  private final static int ОРЕХОВО_БОРИСОВО_ЮЖНОЕ = 126;
  private final static int ЦАРИЦЫНО = 127;
  private final static int ЧЕРТАНОВО_СЕВЕРНОЕ = 128;
  private final static int ЧЕРТАНОВО_ЦЕНТРАЛЬНОЕ = 129;
  private final static int ЧЕРТАНОВО_ЮЖНОЕ = 130;

  public static void main(String[] args) {
    Parameter requestParameter = new Parameter();
    requestParameter.setYear(2017);
    requestParameter.setFrom(LocalDate.of(2017, 2, 1));
    requestParameter.setTo(LocalDate.of(2017, 4, 5));
    new Facade().action(requestParameter);
//    IssueParser issueParser = new IssueParser("http://gorod.mos.ru/?show=problem&m=12&y=2012&selected=%C4%E5%EA%E0%E1%F0%FC%202012;01.12.2012%2000:00:00;31.12.2012%2000:00:00;2012&id_theme=1&page=");
//    http://gorod.mos.ru/?show=problem&id_theme=1&m=11&y=2012&selected=%CD%EE%FF%E1%F0%FC%202012;01.11.2012%2000:00:00;30.11.2012%2000:00:00;2012
//    List<IssueEntity> parse = issueParser.parse(1, 250);
    System.out.println();
  }

}
