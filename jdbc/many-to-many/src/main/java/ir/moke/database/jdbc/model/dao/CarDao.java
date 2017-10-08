package ir.moke.database.jdbc.model.dao;

import ir.moke.database.jdbc.model.to.CarTo;
import ir.moke.database.jdbc.model.to.PersonTo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDao {
    private Connection connection;
    private PreparedStatement preparedStatement;

    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public CarDao() {
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "mahsom", "mypass");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(CarTo carTo) {
        try {
            preparedStatement = connection.prepareStatement("insert into cars (id,name) values(?,?)");
            preparedStatement.setLong(1, carTo.getId());
            preparedStatement.setString(2, carTo.getName());
            preparedStatement.executeUpdate();
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(CarTo carTo) {
        try {
            preparedStatement = connection.prepareStatement("update cars set name=? where id=?");
            preparedStatement.setString(1, carTo.getName());
            preparedStatement.setLong(3, carTo.getId());
            preparedStatement.executeUpdate();
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(long id) {
        try {
            preparedStatement = connection.prepareStatement("delete from cars where id=?");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public CarTo select(long id) {
        CarTo carTo = new CarTo();
        try {
            preparedStatement = connection.prepareStatement("select * from cars where id=?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                carTo = unmarshaller(resultSet);
            }
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carTo;
    }


    public List<CarTo> select() {
        List<CarTo> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select * from cars");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(unmarshaller(resultSet));
            }
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static CarTo unmarshaller(ResultSet resultSet) {
        CarTo carTo = new CarTo();
        try {
            carTo.setId(resultSet.getLong("id"));
            carTo.setName(resultSet.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carTo;
    }

    private void close() {
        try {
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
