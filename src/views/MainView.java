package views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import models.Car;
import models.DataService;
import models.api.Restapi;

public class MainView extends VBox {

    Label carsLabel;
    DataService datasService;
    Restapi restapi;
    Button addButton;
    Button deleteButton;
    Button exitButton;

    private TableView<Car> tableView;

    public MainView() {

        carsLabel = new Label("Autók");
        this.initData();
        this.initTable();
        this.getChildren().add(carsLabel);
        this.getChildren().add(tableView);
        this.Buttons();
    }

    private void initTable() {

        tableView = new TableView<>();
        tableView.setPrefSize(500, 300);

        TableColumn<Car, Integer> idCol = new TableColumn<>("Id");
        idCol.setMinWidth(50);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Car, String> nameCol = new TableColumn<>("Név");
        nameCol.setMinWidth(50);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<Car, String> brandCol = new TableColumn<>("Márka");
        brandCol.setMinWidth(50);
        brandCol.setCellValueFactory(new PropertyValueFactory<>("brand"));
        brandCol.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<Car, String> platenumberCol = new TableColumn<>("Rendszám");
        platenumberCol.setMinWidth(50);
        platenumberCol.setCellValueFactory(new PropertyValueFactory<>("platenumber"));
        platenumberCol.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<Car, Integer> quantityCol = new TableColumn<>("Mennyiség");
        quantityCol.setMinWidth(50);
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        quantityCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        TableColumn<Car, Integer> spaceCol = new TableColumn<>("Férőhely");
        spaceCol.setMinWidth(50);
        spaceCol.setCellValueFactory(new PropertyValueFactory<>("space"));
        spaceCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        TableColumn<Car, String> gearboxCol = new TableColumn<>("Váltó");
        gearboxCol.setMinWidth(50);
        gearboxCol.setCellValueFactory(new PropertyValueFactory<>("gearbox"));
        gearboxCol.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<Car, Double> priceCol = new TableColumn<>("Ár");
        priceCol.setMinWidth(50);
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        priceCol.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        tableView.setEditable(true);

        tableView.setItems(this.getCars());

        tableView.getColumns().add(idCol);
        tableView.getColumns().add(nameCol);
        tableView.getColumns().add(brandCol);
        tableView.getColumns().add(platenumberCol);
        tableView.getColumns().add(quantityCol);
        tableView.getColumns().add(spaceCol);
        tableView.getColumns().add(gearboxCol);
        tableView.getColumns().add(priceCol);

        // Restapi restApi = new Restapi();
        // boolean success = restApi.checkUrl("http://localhost:8000");
        // if(success) {
        // tableView.setItems(this.getCars());
        // }else {
        // System.out.println("A REST API nem elérhető!");
        // }
    }

    private void Buttons() {

        // hozzáad gomb

        this.addButton = new Button();
        this.addButton.setText("Hozzáadás");
        this.getChildren().add(this.addButton);
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                GridPane grid = new GridPane();

                grid.setAlignment(Pos.CENTER);
                grid.setHgap(10);
                grid.setVgap(10);
                grid.setPadding(new Insets(25, 25, 25, 25));

                // Add labels and text fields for make, model, year, and color
                Label nameLabel = new Label("Név:");
                grid.add(nameLabel, 0, 0);
                TextField nameField = new TextField();
                grid.add(nameField, 1, 0);

                Label brandLabel = new Label("Márka:");
                grid.add(brandLabel, 0, 1);
                TextField brandField = new TextField();
                grid.add(brandField, 1, 1);

                Label platenumberLabel = new Label("Rendszám:");
                grid.add(platenumberLabel, 0, 2);
                TextField platenumberField = new TextField();
                grid.add(platenumberField, 1, 2);

                Label quantityLabel = new Label("Mennyiség:");
                grid.add(quantityLabel, 0, 3);
                TextField quantityField = new TextField();
                grid.add(quantityField, 1, 3);

                Label spaceLabel = new Label("Férőhely:");
                grid.add(spaceLabel, 0, 4);
                TextField spaceField = new TextField();
                grid.add(spaceField, 1, 4);

                Label gearboxLabel = new Label("Váltó:");
                grid.add(gearboxLabel, 0, 5);
                TextField gearboxField = new TextField();
                grid.add(gearboxField, 1, 5);

                Label priceLabel = new Label("Ár:");
                grid.add(priceLabel, 0, 6);
                TextField priceField = new TextField();
                grid.add(priceField, 1, 6);

                // HBox, mentés és mezők űrítése gomb
                HBox hbBtn = new HBox(10);
                hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
                Button submitButton = new Button("Submit");
                Button clearButton = new Button("Clear");
                hbBtn.getChildren().addAll(submitButton, clearButton);
                grid.add(hbBtn, 1, 7);

                Stage addStage = new Stage();
                Scene addScene = new Scene(grid, 300, 350);
                addStage.setTitle("Új autó felvétele");
                addStage.setScene(addScene);
                addStage.show();

                // mentés gomb
                // submitButton.setOnAction(event -> {

                // });

                // mezők ürítése gomb
                clearButton.setOnAction(event -> {
                    nameField.setText("");
                    brandField.setText("");
                    platenumberField.setText("");
                    quantityField.setText("");
                    spaceField.setText("");
                    gearboxField.setText("");
                    priceField.setText("");
                });
            }
        });

        // torles gomb
        this.deleteButton = new Button();
        this.deleteButton.setText("Torles");
        this.getChildren().add(this.deleteButton);
        this.deleteButton.setPadding(new Insets(0, 20, 10, 20));
        this.deleteButton.setOnAction(e -> {
            tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItem());
            ObservableList<Car> selectedCar, car;
            car = tableView.getItems();
            selectedCar = tableView.getSelectionModel().getSelectedItems();
            selectedCar.forEach(car::remove);
        });

        // kilepés
        this.exitButton = new Button();
        this.exitButton.setText("Kilépés");
        this.getChildren().add(this.exitButton);
        this.exitButton.setPadding(new Insets(0, 20, 10, 20));
        exitButton.setOnAction((ActionEvent event) -> {
            System.exit(0);
        });
    }

    private ObservableList<Car> getCars() {
        ObservableList<Car> carsList = FXCollections.observableArrayList(restapi.getCars());
        return carsList;
    }

    private void initData() {
        this.restapi = new Restapi();
    }
}