package models;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataService {
    Database database;
    Connection con;

    public DataService(Database database) {
        this.database = database;
        con = this.database.connect();
    }

    public ArrayList<Car> getCars() {
        ArrayList<Car> carsList = null;
        try {
            carsList = tryGetCars();
        } catch (SQLException e) {
            System.err.println("Hiba! A termék lekérdezése sikertelen!");
        }
        return carsList;
    }

    public ArrayList<Car> tryGetCars() throws SQLException {
        String sql = "select * from cars";
        Statement statement = this.con.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<Car> carsList = new ArrayList<>();
        while (resultSet.next()) {
            Car cars = new Car(0, sql, sql, sql, 0, 0, sql, 0);
            cars.id = resultSet.getInt("id");
            cars.name = resultSet.getString("name");
            cars.brand = resultSet.getString("brand");
            cars.platenumber = resultSet.getString("platenumber");
            cars.quantity = resultSet.getInt("quantity");
            cars.space = resultSet.getInt("space");
            cars.gearbox = resultSet.getString("gearbox");
            cars.price = resultSet.getDouble("price");
        }
        return carsList;
    }
}
