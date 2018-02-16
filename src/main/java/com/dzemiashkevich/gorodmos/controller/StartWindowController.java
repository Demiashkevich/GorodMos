package com.dzemiashkevich.gorodmos.controller;

import com.dzemiashkevich.gorodmos.entity.Parameter;
import com.dzemiashkevich.gorodmos.entity.jfx.RegionJFX;
import com.dzemiashkevich.gorodmos.facade.Facade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;

public class StartWindowController {

    @FXML
    private DatePicker from;

    @FXML
    private DatePicker to;

    @FXML
    private ChoiceBox<RegionJFX> zone;

    @FXML
    private ChoiceBox<RegionJFX> district;

    @FXML
    private Button parse;

    private LocalDate dateFrom;
    private LocalDate dateTo;
    private int intZone;
    private int intDistinct;

    public void initialize() {
        zone.setItems(FXCollections.observableArrayList(
                new RegionJFX("ВОСТОЧНЫЙ ОКРУГ", 1 ),
                new RegionJFX("ЗАПАДНЫЙ ОКРУГ", 19),
                new RegionJFX("ЗЕЛЕНОГРАДСКИЙ ОКРУГ", 131),
                new RegionJFX("НОВОМОСКОВСКИЙ ОКРУГ", 138),
                new RegionJFX("СЕРВЕРНЫЙ ОКРУГ", 33),
                new RegionJFX("СЕВЕРО-ВОСТОЧНЫЙ ОКРУГ", 50),
                new RegionJFX("СЕВЕРО-ЗАПАДНЫЙ ОКРУГ", 68),
                new RegionJFX("ТРОИЦКИЙ ОКРУГ", 137),
                new RegionJFX("ЦЕНТРАЛЬНЫЙ ОКРУГ", 77),
                new RegionJFX("ЮГО-ВОСТОЧНЫЙ ОКРУГ", 88),
                new RegionJFX("ЮГО-ЗАПАДНЫЙ ОКРУГ", 101),
                new RegionJFX("ЮЖНЫЙ-ОКРУГ", 114)
        ));

        zone.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            intZone = newValue.getCode();
            switch (newValue.getCode()) {
                case 1:
                    district.setItems(regionJFX1);
                    break;
                case 19:
                    district.setItems(regionJFX2);
                    break;
                case 131:
                    district.setItems(regionJFX3);
                    break;
                case 138:
                    district.setItems(regionJFX4);
                    break;
                case 33:
                    district.setItems(regionJFX5);
                    break;
                case 50:
                    district.setItems(regionJFX6);
                    break;
                case 68:
                    district.setItems(regionJFX7);
                    break;
                case 137:
                    district.setItems(regionJFX8);
                    break;
                case 77:
                    district.setItems(regionJFX9);
                    break;
                case 88:
                    district.setItems(regionJFX10);
                    break;
                case 101:
                    district.setItems(regionJFX11);
                    break;
                case 114:
                    district.setItems(regionJFX12);
                    break;
            }
        });

        district.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            intDistinct = newValue.getCode();
        });

        from.setOnAction(event -> dateFrom = from.getValue());
        to.setOnAction(event -> dateTo = to.getValue());

        parse.setOnAction(event -> {
            Parameter parameter = new Parameter();
            parameter.setFrom(dateFrom);
            parameter.setTo(dateTo);
            parameter.setDistinct(intDistinct);
            parameter.setZone(intZone);
            Facade facade = new Facade();
            facade.action(parameter);
        });
    }

    private static final ObservableList<RegionJFX> regionJFX1 = FXCollections.observableArrayList(
            new RegionJFX("БОГОРОДСКОЕ", 2),
            new RegionJFX("ВЕШНЯКИ", 3),
            new RegionJFX("ВОСТОЧНОЕ_ИЗМАЙЛОВО", 4),
            new RegionJFX("ВОСТОЧНЫЙ", 6),
            new RegionJFX("ГОЛЬЯНОВО", 7),
            new RegionJFX("ИВАНОВСКОЕ", 8),
            new RegionJFX("ИЗМАЙЛОВО", 9),
            new RegionJFX("КОСИНО_УХТОМСКИЙ", 10),
            new RegionJFX("МЕТРОГОРОДОК", 11),
            new RegionJFX("НОВОГИРЕЕВО", 12),
            new RegionJFX("ПЕТРОВО", 13),
            new RegionJFX("НОВОКОСИНО", 14),
            new RegionJFX("ПРЕОБРАЖЕНСКОЕ", 15),
            new RegionJFX("СЕВЕРНОЕ_ИЗМАЙЛОВО", 16),
            new RegionJFX("СОКОЛИНАЯ_ГОРА", 17),
            new RegionJFX("СОКОЛЬНИКИ", 18)
    );

    private static final ObservableList<RegionJFX> regionJFX2 = FXCollections.observableArrayList(
            new RegionJFX("ВНУКОВО", 20),
            new RegionJFX("ДОРОГОМИЛОВО", 21),
            new RegionJFX("КРЫЛАТСКОЕ", 22),
            new RegionJFX("КУНЦЕВО", 23),
            new RegionJFX("МОЖАЙСКИЙ", 24),
            new RegionJFX("НОВО_ПЕРЕДЕЛКИНО", 25),
            new RegionJFX("ОЧАКОВО_МАТВЕЕВСКОЕ", 26),
            new RegionJFX("ПРОСПЕКТ_ВЕРНАДСКОГО", 27),
            new RegionJFX("РАМЕНКИ", 28),
            new RegionJFX("СОЛНЦЕВО", 29),
            new RegionJFX("ТРОПАРЕВО_НИКУЛЕНО", 30),
            new RegionJFX("ФИЛЕВСКИЙ_ПАРК", 31),
            new RegionJFX("ФИЛИ_ДАВЫДКОВО", 32)
    );

    private static final ObservableList<RegionJFX> regionJFX3 = FXCollections.observableArrayList(
            new RegionJFX("КРЮКОВО", 132),
            new RegionJFX("МАТУШКИНО", 133),
            new RegionJFX("САВЕЛКИ", 134),
            new RegionJFX("СИЛИНО", 135),
            new RegionJFX("СТАРОЕ_КРЮКОВО", 136)
    );

    private static final ObservableList<RegionJFX> regionJFX4 = FXCollections.observableArrayList(
            new RegionJFX("ЩЕРБИНКА", 140)
    );

    private static final ObservableList<RegionJFX> regionJFX5 = FXCollections.observableArrayList(
            new RegionJFX("АЭРОПОРТ", 34),
            new RegionJFX("БЕГОВОЙ", 35),
            new RegionJFX("БЕСКУДНИКОВСКИЙ", 36),
            new RegionJFX("ВОЙКОВСКИЙ", 37),
            new RegionJFX("ВОСТОЧНОЕ_ДЕГУНИНО", 38),
            new RegionJFX("ГОЛОВИНСКИЙ", 39),
            new RegionJFX("ДМИТРОВСКИЙ", 40),
            new RegionJFX("ЗАПАДНОЕ_ДЕГУНИНО", 41),
            new RegionJFX("КОПТЕВО", 42),
            new RegionJFX("ЛЕВОБЕРЕЖНЫЙ", 43),
            new RegionJFX("МОЛЖАНИНОВСКИЙ", 44),
            new RegionJFX("САВЕЛОВСКИЙ", 45),
            new RegionJFX("СОКОЛ", 46),
            new RegionJFX("ТИМИРЯЗЕВСКИЙ", 47),
            new RegionJFX("ХОВРИНО", 48),
            new RegionJFX("ХОРОШЕВСКИЙ", 49)
    );

    private static final ObservableList<RegionJFX> regionJFX6 = FXCollections.observableArrayList(
            new RegionJFX("АЛЕКСЕЕВСКИЙ", 51),
            new RegionJFX("АЛТУФЬЕВСКИЙ", 52),
            new RegionJFX("БАБУШКИНСКИЙ", 53),
            new RegionJFX("БИБЕРЕВО", 54),
            new RegionJFX("БУТЫРСКИЙ", 55),
            new RegionJFX("ЛИАНОЗОВО", 56),
            new RegionJFX("ЛОСИНООСТРОВСКИЙ", 57),
            new RegionJFX("МАРФИНО", 58),
            new RegionJFX("МАРЬИНА_РОЩА", 59),
            new RegionJFX("ОСТАНКИНСКИЙ", 60),
            new RegionJFX("ОТРАДНОЕ", 61),
            new RegionJFX("РОСТОКИНО", 62),
            new RegionJFX("СВИБЛОВО", 63),
            new RegionJFX("СЕВЕРНОЕ_МЕДВЕДКИНО", 64),
            new RegionJFX("СЕВЕРНЫЙ", 65),
            new RegionJFX("ЮЖНОЕ_МЕДВЕДКОВО", 66),
            new RegionJFX("ЯРОСЛАВСКИЙ", 67)
    );

    private static final ObservableList<RegionJFX> regionJFX7 = FXCollections.observableArrayList(
            new RegionJFX("КУРКИНО", 69),
            new RegionJFX("МИТИНО", 70),
            new RegionJFX("ПОКРОВСКОЕ_СТРЕШНЕВО", 71),
            new RegionJFX("СЕВЕРНОЕ_ТУШИНО", 72),
            new RegionJFX("СТРОГИНО", 73),
            new RegionJFX("ХОРОШЕВО_МНЕВНИКИ", 74),
            new RegionJFX("ЩУКИНО", 75),
            new RegionJFX("ЮЖНОЕ_ТУШИНО", 76)
    );

    private static final ObservableList<RegionJFX> regionJFX8 = FXCollections.observableArrayList(
            new RegionJFX("ТРОИЦК", 141)
    );

    private static final ObservableList<RegionJFX> regionJFX9 = FXCollections.observableArrayList(
            new RegionJFX("АРБАТ", 78),
            new RegionJFX("БАСМАННЫЙ", 79),
            new RegionJFX("ЗАМОСКВОРЕЧЬЕ", 80),
            new RegionJFX("КРАСНОСЕЛЬСКИЙ", 81),
            new RegionJFX("МЕЩАНСКИЙ", 82),
            new RegionJFX("ПРЕСНЕНСКИЙ", 83),
            new RegionJFX("ТАГАНСКИЙ", 84),
            new RegionJFX("ТВЕРСКОЙ", 85),
            new RegionJFX("ХАМОВНИКИ", 86),
            new RegionJFX("ЯКИМАНКА", 87)
    );

    private static final ObservableList<RegionJFX> regionJFX10 = FXCollections.observableArrayList(
            new RegionJFX("ВЫХИНО_ЖУЛЕБИНО", 89),
            new RegionJFX("КАПОТНЯ", 90),
            new RegionJFX("КУЗЬМИНКИ", 91),
            new RegionJFX("ЛЕФОРТОВО", 92),
            new RegionJFX("ЛЮБЛИНО", 93),
            new RegionJFX("МАРЬИНО", 94),
            new RegionJFX("НЕКРАСОВКА", 95),
            new RegionJFX("НИЖЕГОРОДСКИЙ", 96),
            new RegionJFX("ПЕЧАТНИКИ", 97),
            new RegionJFX("РЯЗАНСКИЙ", 98),
            new RegionJFX("ТЕКСТИЛЬЩИКИ", 99),
            new RegionJFX("ЮЖНОПОРТОВЫЙ", 100)
    );

    private static final ObservableList<RegionJFX> regionJFX11 = FXCollections.observableArrayList(
            new RegionJFX("АКАДЕМИЧЕСКИЙ", 102),
            new RegionJFX("ГАГАРИНСКИЙ", 103),
            new RegionJFX("ЗЮЗИНО", 104),
            new RegionJFX("КОНЬКОВО", 105),
            new RegionJFX("КОТЛОВКА", 106),
            new RegionJFX("ЛОМОНОСОВСКИЙ", 107),
            new RegionJFX("ОБРУЧЕВСКИЙ", 108),
            new RegionJFX("СЕВЕРНОЕ_БУТЛОВО", 109),
            new RegionJFX("ТЕПЛЫЙ_СТАН", 110),
            new RegionJFX("ЧЕРЕМУШКИ", 111),
            new RegionJFX("ЮЖНОЕ_БУТЛОВО", 112),
            new RegionJFX("ЯСЕНЕВО", 113)
    );


    private static final ObservableList<RegionJFX> regionJFX12 = FXCollections.observableArrayList(
            new RegionJFX("БИРЮЛЕВО_ВОСТОЧНОЕ", 115),
            new RegionJFX("БИРЮЛЕВО_ЗАПАДНОЕ", 116),
            new RegionJFX("БРАТЕЕВО", 117),
            new RegionJFX("ДАНИЛОВСКИЙ", 118),
            new RegionJFX("ДОНСКОЙ", 119),
            new RegionJFX("ЗЯБЛИКОВО", 120),
            new RegionJFX("МОСКВОРЕЧЬЕ_САБУРОВО", 121),
            new RegionJFX("НАГАТИНО_САДОВНИКИ", 122),
            new RegionJFX("НАГАТИНСКИЙ_ЗАТОН", 123),
            new RegionJFX("НАГОРНЫЙ", 124),
            new RegionJFX("ОРЕХОВО_БОРИСОВО_СЕВЕРНОЕ", 125),
            new RegionJFX("ОРЕХОВО_БОРИСОВО_ЮЖНОЕ", 126),
            new RegionJFX("ЦАРИЦЫНО", 127),
            new RegionJFX("ЧЕРТАНОВО_СЕВЕРНОЕ", 128),
            new RegionJFX("ЧЕРТАНОВО_ЦЕНТРАЛЬНОЕ", 129),
            new RegionJFX("ЧЕРТАНОВО_ЮЖНОЕ", 130)
    );

}
