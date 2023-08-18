package org.example.dao;

import org.example.model.BankAccount;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class BankAccountDAO extends BaseDAO<BankAccount>{


    public BankAccountDAO(Connection connection) {
        super(connection);
    }
    @Override
    public boolean save(BankAccount element) throws SQLException {
        request = "INSERT INTO bank_account (client_id, solde) VALUES (?, ?)";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setFloat(2, element.getSolde());
        statement.setInt(1, element.getId());
        int nbRows = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()){
            element.setId(resultSet.getInt(1));
        }
        return nbRows == 1;
    }

    @Override
    public boolean update(BankAccount element) throws SQLException {
        request = "UPDATE bank_account set solde = ?, client_id = ? where id = ?";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setFloat(1,element.getSolde());
        statement.setInt(2,element.getClient().getId());
        statement.setInt(3,element.getId());
        int nbRow = statement.executeUpdate();
        return nbRow ==1;
    }

    @Override
    public boolean delete(BankAccount element) throws SQLException {

        return false;
    }

    @Override
    public BankAccount get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<BankAccount> get() throws SQLException {
        return null;
    }
}
