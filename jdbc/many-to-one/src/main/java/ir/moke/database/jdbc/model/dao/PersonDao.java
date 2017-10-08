package ir.moke.database.jdbc.model.dao;

import ir.moke.database.jdbc.model.to.PersonTo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {
    private Connection connection;
    private PreparedStatement preparedStatement ;

    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public PersonDao() {
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "mahsom", "mypass");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(PersonTo personTo) {
        try {
            preparedStatement = connection.prepareStatement("insert into persons (id,name,family) values(?,?,?)");
            preparedStatement.setLong(1, personTo.getId());
            preparedStatement.setString(2, personTo.getName());
            preparedStatement.setString(3, personTo.getFamily());
            preparedStatement.executeUpdate();
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(PersonTo personTo) {
        try {
            preparedStatement = connection.prepareStatement("update persons set name=? and family=? where id=?");
            preparedStatement.setString(1, personTo.getName());
            preparedStatement.setString(2, personTo.getFamily());
            preparedStatement.setLong(3, personTo.getId());
            preparedStatement.executeUpdate();
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(long id) {
        try {
            preparedStatement = connection.prepareStatement("delete from persons where id=?");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PersonTo select(long id) {
        PersonTo personTo = new PersonTo();
        try {
            preparedStatement = connection.prepareStatement("select * from persons where id=?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                personTo = unmarshaller(resultSet);
            }
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personTo;
    }


    public List<PersonTo> select() {
        List<PersonTo> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select * from persons");
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

    private static PersonTo unmarshaller(ResultSet resultSet) {
        PersonTo personTo = new PersonTo();
        try {
            personTo.setId(resultSet.getLong("id"));
            personTo.setName(resultSet.getString("name"));
            personTo.setFamily(resultSet.getString("family"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personTo;
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
