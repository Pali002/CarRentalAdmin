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
    TextField idField;
    TextField nameField;
    TextField brandField;
    TextField platenumberField;
    TextField quantityField;
    TextField gearboxField;
    TextField priceField;
    Button submitButton;
    Button clearButton;

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
        idCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

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
        this.addButton.setPadding(new Insets(0, 20, 10, 20));
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                GridPane grid = new GridPane();

                grid.setAlignment(Pos.CENTER);
                grid.setHgap(10);
                grid.setVgap(10);
                grid.setPadding(new Insets(25, 25, 25, 25));

                Label idLabel = new Label("Id:");
                grid.add(idLabel, 0, 0);
                idField = new TextField();
                grid.add(idField, 1, 0);

                Label nameLabel = new Label("Név:");
                grid.add(nameLabel, 0, 1);
                nameField = new TextField();
                grid.add(nameField, 1, 1);

                Label brandLabel = new Label("Márka:");
                grid.add(brandLabel, 0, 2);
                brandField = new TextField();
                grid.add(brandField, 1, 2);

                Label platenumberLabel = new Label("Rendszám:");
                grid.add(platenumberLabel, 0, 3);
                platenumberField = new TextField();
                grid.add(platenumberField, 1, 3);

                Label quantityLabel = new Label("Mennyiség:");
                grid.add(quantityLabel, 0, 4);
                quantityField = new TextField();
                grid.add(quantityField, 1, 4);

                Label gearboxLabel = new Label("Váltó:");
                grid.add(gearboxLabel, 0, 5);
                gearboxField = new TextField();
                grid.add(gearboxField, 1, 5);

                Label priceLabel = new Label("Ár:");
                grid.add(priceLabel, 0, 6);
                priceField = new TextField();
                grid.add(priceField, 1, 6);

                // Label messageLabel = new Label("Sikeres hozzáadás");
                // grid.add(messageLabel, 0, 8);
                // messageLabel.setVisible(false);

                // HBox, mentés és mezők űrítése gomb
                HBox hbBtn = new HBox(10);
                hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
                submitButton = new Button("Hozzáasás");
                clearButton = new Button("Törlés");
                hbBtn.getChildren().addAll(submitButton, clearButton);
                grid.add(hbBtn, 1, 9);

                Stage addStage = new Stage();
                Scene addScene = new Scene(grid, 350, 350);
                addStage.setTitle("Új autó felvétele");
                addStage.setScene(addScene);
                addStage.show();

                // mentés gomb
                submitButton.setOnAction(event -> {
                    Car car = new Car(Integer.parseInt(idField.getText()), nameField.getText(), brandField.getText(),
                            platenumberField.getText(),
                            Integer.parseInt(quantityField.getText()),
                            gearboxField.getText(),
                            Double.parseDouble(priceField.getText()));
                    tableView.getItems().add(car);
                });

                // mezők ürítése gomb
                clearButton.setOnAction(event -> {
                    idField.setText("");
                    nameField.setText("");
                    brandField.setText("");
                    platenumberField.setText("");
                    quantityField.setText("");
                    gearboxField.setText("");
                    priceField.setText("");
                });
            }
        });

        // torles gomb
        this.deleteButton = new Button();
        this.deleteButton.setText("Törlés");
        this.getChildren().add(this.deleteButton);
        this.deleteButton.setPadding(new Insets(0, 20, 10, 20));
        this.deleteButton.setOnAction(e -> {
            Car selectedCar = tableView.getSelectionModel().getSelectedItem();
            if (selectedCar != null) {
                tableView.getItems().remove(selectedCar);
            }
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