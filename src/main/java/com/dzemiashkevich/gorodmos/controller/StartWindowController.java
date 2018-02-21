package com.dzemiashkevich.gorodmos.controller;

import com.dzemiashkevich.gorodmos.action.ExcelWriter;
import com.dzemiashkevich.gorodmos.entity.IssueEntity;
import com.dzemiashkevich.gorodmos.entity.Parameter;
import com.dzemiashkevich.gorodmos.entity.jfx.RegionJFX;
import com.dzemiashkevich.gorodmos.facade.Facade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.stage.FileChooser;
import javafx.util.Callback;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

public class StartWindowController {

    @FXML
    private ChoiceBox<RegionJFX> issueCode;

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
    private int intIssueCode;

    public void initialize() {
        Callback<DatePicker, DateCell> dayCellFactoryFrom = dp -> new DateCell()
        {
            @Override
            public void updateItem(LocalDate item, boolean empty)
            {
                super.updateItem(item, empty);

                if(item.isBefore(LocalDate.of(2012, 1, 1)) || item.isAfter(LocalDate.now().minusDays(1)))
                {
                    setStyle("-fx-background-color: #ffc0cb; -fx-text-fill: darkgray;");
                    setDisable(true);
                }
            }
        };
        from.setDayCellFactory(dayCellFactoryFrom);

        Callback<DatePicker, DateCell> dayCellFactoryTo = dp -> new DateCell()
        {
            @Override
            public void updateItem(LocalDate item, boolean empty)
            {
                super.updateItem(item, empty);

                if(item.isBefore(LocalDate.of(2012, 1, 2)) || item.isAfter(LocalDate.now()))
                {
                    setStyle("-fx-background-color: #ffc0cb; -fx-text-fill: darkgray;");
                    setDisable(true);
                }
            }
        };
        to.setDayCellFactory(dayCellFactoryTo);

        issueCode.setItems(FXCollections.observableArrayList(
            new RegionJFX("Все проблемы".toUpperCase(), 0),
            new RegionJFX("Дворовые территории".toUpperCase(), 53),
            new RegionJFX("Многоквартирные дома".toUpperCase(), 16),
            new RegionJFX("Дороги".toUpperCase(), 20301),
            new RegionJFX("Поликлиники".toUpperCase(),3),
            new RegionJFX("Парки".toUpperCase(),20317),
            new RegionJFX("Несанкционированные торговые объекты".toUpperCase(), 20168),
            new RegionJFX("Ярмарки выходного дня".toUpperCase(), 20340),
            new RegionJFX("Летние кафе".toUpperCase(), 20165),
            new RegionJFX("Рекламные и информационные конструкции".toUpperCase(), 20319),
            new RegionJFX("Общественный транспорт".toUpperCase(), 20308),
            new RegionJFX("Остановки общественного транспорта".toUpperCase(), 20309),
            new RegionJFX("Коммерческое строительство".toUpperCase(), 20321),
            new RegionJFX("Стройплощадки".toUpperCase(), 20307),
            new RegionJFX("Многофункциональные центры".toUpperCase(), 20312),
            new RegionJFX("Билетные киоски".toUpperCase(), 20315),
            new RegionJFX("Паркоматы".toUpperCase(), 20300),
            new RegionJFX("Переходные переходы".toUpperCase(), 20314),
            new RegionJFX("Общественные туалеты".toUpperCase(), 20313),
            new RegionJFX("Объекты безвозмездного пользования".toUpperCase(), 20320),
            new RegionJFX("Городская территория".toUpperCase(), 20332),
            new RegionJFX("Учреждения социальной сферы".toUpperCase(), 20325),
            new RegionJFX("Метрополитен".toUpperCase(), 20121),
            new RegionJFX("Полиция".toUpperCase(), 20354)
        ));
        issueCode.getSelectionModel().select(0);

        zone.setItems(FXCollections.observableArrayList(
                new RegionJFX("ВСЕ ОБЛАСТИ",0),
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
        zone.getSelectionModel().select(0);

        issueCode.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                return;
            }
            intIssueCode = newValue.getCode();
        });

        zone.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                return;
            }
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
            district.getSelectionModel().select(0);
        });

        district.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                return;
            }
            intDistinct = newValue.getCode();
        });

        from.setOnAction(event -> dateFrom = from.getValue());
        to.setOnAction(event -> dateTo = to.getValue());

        parse.setOnAction(event -> {
            if (from.getValue() == null && to.getValue() == null) {
                from.setStyle("-fx-border-color: red;");
                to.setStyle("-fx-border-color: red;");
                return;
            }
            if (from.getValue() == null) {
                from.setStyle("-fx-border-color: red;");
                return;
            }
            if (to.getValue() == null) {
                to.setStyle("-fx-border-color: red;");
                return;
            }
            final Parameter parameter = new Parameter();
            parameter.setFrom(dateFrom);
            parameter.setTo(dateTo);
            parameter.setDistinct(intDistinct);
            parameter.setZone(intZone);
            parameter.setIssueCode(intIssueCode);
            final Facade facade = new Facade();
            final List<IssueEntity> filterIssue = facade.action(parameter);
            final FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excel (*.xlsx)", "*.xlsx");
            fileChooser.setTitle("Сохранить найденные проблемы");
            fileChooser.getExtensionFilters().add(extFilter);
            final File file = fileChooser.showSaveDialog(parse.getScene().getWindow());
            final ExcelWriter excelWriter = new ExcelWriter(file.getAbsolutePath());
            excelWriter.writeIssue(filterIssue);
        });

    }

    private static final ObservableList<RegionJFX> regionJFX1 = FXCollections.observableArrayList(
            new RegionJFX("ВСЕ РАЙОНЫ", 0),
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
            new RegionJFX("ВСЕ РАЙОНЫ", 0),
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
            new RegionJFX("ВСЕ РАЙОНЫ", 0),
            new RegionJFX("КРЮКОВО", 132),
            new RegionJFX("МАТУШКИНО", 133),
            new RegionJFX("САВЕЛКИ", 134),
            new RegionJFX("СИЛИНО", 135),
            new RegionJFX("СТАРОЕ_КРЮКОВО", 136)
    );

    private static final ObservableList<RegionJFX> regionJFX4 = FXCollections.observableArrayList(
            new RegionJFX("ВСЕ РАЙОНЫ", 0),
            new RegionJFX("ЩЕРБИНКА", 140)
    );

    private static final ObservableList<RegionJFX> regionJFX5 = FXCollections.observableArrayList(
            new RegionJFX("ВСЕ РАЙОНЫ", 0),
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
            new RegionJFX("ВСЕ РАЙОНЫ", 0),
            new RegionJFX("АЛЕКСЕЕВСКИЙ", 51),
            new RegionJFX("АЛТУФЬЕВСКИЙ", 52),
            new RegionJFX("БАБУШКИНСКИЙ", 53),
            new RegionJFX("БИБЕРЕВО", 54),
            new RegionJFX("БУТЫРСКИЙ", 55),
            new RegionJFX("ЛИАНОЗОВО", 56),
            new RegionJFX("ЛОСИНООСТРОВСКИЙ", 57),
            new RegionJFX("МАРФИНО", 58),
            new RegionJFX("МАРЬИНА РОЩА", 59),
            new RegionJFX("ОСТАНКИНСКИЙ", 60),
            new RegionJFX("ОТРАДНОЕ", 61),
            new RegionJFX("РОСТОКИНО", 62),
            new RegionJFX("СВИБЛОВО", 63),
            new RegionJFX("СЕВЕРНОЕ МЕДВЕДКИНО", 64),
            new RegionJFX("СЕВЕРНЫЙ", 65),
            new RegionJFX("ЮЖНОЕ МЕДВЕДКОВО", 66),
            new RegionJFX("ЯРОСЛАВСКИЙ", 67)
    );

    private static final ObservableList<RegionJFX> regionJFX7 = FXCollections.observableArrayList(
            new RegionJFX("ВСЕ РАЙОНЫ", 0),
            new RegionJFX("КУРКИНО", 69),
            new RegionJFX("МИТИНО", 70),
            new RegionJFX("ПОКРОВСКОЕ СТРЕШНЕВО", 71),
            new RegionJFX("СЕВЕРНОЕ ТУШИНО", 72),
            new RegionJFX("СТРОГИНО", 73),
            new RegionJFX("ХОРОШЕВО МНЕВНИКИ", 74),
            new RegionJFX("ЩУКИНО", 75),
            new RegionJFX("ЮЖНОЕ ТУШИНО", 76)
    );

    private static final ObservableList<RegionJFX> regionJFX8 = FXCollections.observableArrayList(
            new RegionJFX("ВСЕ РАЙОНЫ", 0),
            new RegionJFX("ТРОИЦК", 141)
    );

    private static final ObservableList<RegionJFX> regionJFX9 = FXCollections.observableArrayList(
            new RegionJFX("ВСЕ РАЙОНЫ", 0),
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
            new RegionJFX("ВСЕ РАЙОНЫ", 0),
            new RegionJFX("ВЫХИНО ЖУЛЕБИНО", 89),
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
            new RegionJFX("ВСЕ РАЙОНЫ", 0),
            new RegionJFX("АКАДЕМИЧЕСКИЙ", 102),
            new RegionJFX("ГАГАРИНСКИЙ", 103),
            new RegionJFX("ЗЮЗИНО", 104),
            new RegionJFX("КОНЬКОВО", 105),
            new RegionJFX("КОТЛОВКА", 106),
            new RegionJFX("ЛОМОНОСОВСКИЙ", 107),
            new RegionJFX("ОБРУЧЕВСКИЙ", 108),
            new RegionJFX("СЕВЕРНОЕ БУТЛОВО", 109),
            new RegionJFX("ТЕПЛЫЙ СТАН", 110),
            new RegionJFX("ЧЕРЕМУШКИ", 111),
            new RegionJFX("ЮЖНОЕ БУТЛОВО", 112),
            new RegionJFX("ЯСЕНЕВО", 113)
    );


    private static final ObservableList<RegionJFX> regionJFX12 = FXCollections.observableArrayList(
            new RegionJFX("ВСЕ РАЙОНЫ", 0),
            new RegionJFX("БИРЮЛЕВО ВОСТОЧНОЕ", 115),
            new RegionJFX("БИРЮЛЕВО ЗАПАДНОЕ", 116),
            new RegionJFX("БРАТЕЕВО", 117),
            new RegionJFX("ДАНИЛОВСКИЙ", 118),
            new RegionJFX("ДОНСКОЙ", 119),
            new RegionJFX("ЗЯБЛИКОВО", 120),
            new RegionJFX("МОСКВОРЕЧЬЕ САБУРОВО", 121),
            new RegionJFX("НАГАТИНО САДОВНИКИ", 122),
            new RegionJFX("НАГАТИНСКИЙ ЗАТОН", 123),
            new RegionJFX("НАГОРНЫЙ", 124),
            new RegionJFX("ОРЕХОВО-БОРИСОВО СЕВЕРНОЕ", 125),
            new RegionJFX("ОРЕХОВО-БОРИСОВО ЮЖНОЕ", 126),
            new RegionJFX("ЦАРИЦЫНО", 127),
            new RegionJFX("ЧЕРТАНОВО СЕВЕРНОЕ", 128),
            new RegionJFX("ЧЕРТАНОВО ЦЕНТРАЛЬНОЕ", 129),
            new RegionJFX("ЧЕРТАНОВО ЮЖНОЕ", 130)
    );

}
