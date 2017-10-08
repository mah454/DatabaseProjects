package ir.moke.database.jdbc.model.dao;

import ir.moke.database.jdbc.model.to.PersonsCars;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonsCarsDao {
    private Connection connection;
    private PreparedStatement preparedStatement;

    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public PersonsCarsDao() {
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "mahsom", "mypass");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(PersonsCars personsCars) {
        try {
            preparedStatement = connection.prepareStatement("insert into persons_cars (id,person_id,car_id) values(?,?,?)");
            preparedStatement.setLong(1, personsCars.getId());
            preparedStatement.setLong(2, personsCars.getPersonId());
            preparedStatement.setLong(3, personsCars.getCarId());
            preparedStatement.executeUpdate();
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(PersonsCars personsCars) {
        try {
            preparedStatement = connection.prepareStatement("update persons_cars set person_id=? and car_id=? where id=?");
            preparedStatement.setLong(1, personsCars.getPersonId());
            preparedStatement.setLong(2, personsCars.getCarId());
            preparedStatement.setLong(3, personsCars.getId());
            preparedStatement.executeUpdate();
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(long id) {
        try {
            preparedStatement = connection.prepareStatement("delete from persons_cars where id=?");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PersonsCars select(long id) {
        PersonsCars personsCars = new PersonsCars();
        try {
            preparedStatement = connection.prepareStatement("select * from persons_cars where id=?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                personsCars = unmarshaller(resultSet);
            }
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personsCars;
    }


    public List<PersonsCars> select() {
        List<PersonsCars> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select * from persons_cars");
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

    private static PersonsCars unmarshaller(ResultSet resultSet) {
        PersonsCars personsCars = new PersonsCars();
        try {
            personsCars.setId(resultSet.getLong("id"));
            personsCars.setPersonId(resultSet.getLong("person_id"));
            personsCars.setCarId(resultSet.getLong("car_id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personsCars;
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
