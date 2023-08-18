package org.example.dao;

import org.example.model.Client;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends BaseDAO<Client>{

    public ClientDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Client element) throws SQLException {
        request = "INSERT INTO client (first_name, last_name, number_phone) VALUES (?,?,?)";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, element.getFirstName());
        statement.setString(2, element.getLastName());
        statement.setString(3, element.getNumPhone());
        int nbRows = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()){
            element.setId(resultSet.getInt(1));
        }
        return nbRows == 1;
    }

    @Override
    public boolean update(Client element) throws SQLException {
        request = "UPDATE client set first_name = ?, last_name = ?, number_phone = ? where id = ?";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,element.getFirstName());
        statement.setString(2,element.getLastName());
        statement.setString(3,element.getNumPhone());
        statement.setInt(4,element.getId());
        int nbRow = statement.executeUpdate();
        return nbRow ==1;
    }

    @Override
    public boolean delete(Client element) throws SQLException {
        request = "DELETE FROM client where id = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1,element.getId());
        int nbRow = statement.executeUpdate();
        return nbRow ==1;
    }

    @Override
    public Client get(int id) throws SQLException {
        Client client = null;
        request = "select * from client where id = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if(resultSet.next()) {
            client = new Client(resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("number_phone"));
        }
        return client;
    }

    public Client getByPhone(String num) throws SQLException {
        Client client = null;
        request = "select * from client where number_phone = ?";
        statement = _connection.prepareStatement(request);
        statement.setString(1, num);
        resultSet = statement.executeQuery();
        if(resultSet.next()) {
            client = new Client(resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("number_phone"));
        }
        return client;
    }


    @Override
    public List<Client> get() throws SQLException {
        List<Client> result = new ArrayList<>();
        request = "select * from person";
        statement = _connection.prepareStatement(request);
        resultSet = statement.executeQuery();
        while(resultSet.next()){
            Client client = new Client(resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("number_phone"));
            result.add(client);
        }
        return result;
    }
}
