package views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
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
        this.addButton.setPadding(new Insets(0, 20, 10, 20));
        this.getChildren().add(this.addButton);
        // this.addButton.setOnAction(new EventHandler<ActionEvent>() {

        // @Override
        // public void handle(ActionEvent event) {
        // Label secondLabel = new Label("Hozzáadás");

        // StackPane secondaryLayout = new StackPane();
        // secondaryLayout.getChildren().addAll(secondLabel);

        // Scene secondScene = new Scene(secondaryLayout, 300, 200);

        // Stage newWindow = new Stage();
        // newWindow.setTitle("Hozzáadás");
        // newWindow.setScene(secondScene);

        // }
        // });

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