package org.example.service;

import org.example.dao.BankAccountDAO;
import org.example.dao.ClientDAO;
import org.example.model.BankAccount;
import org.example.model.Client;
import org.example.util.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BankAccountService {
    private BankAccountDAO bankAccountDAO;
    private Connection connection;

    public BankAccountService() {
        try {
            connection = new DatabaseManager().getConnection();
            bankAccountDAO = new BankAccountDAO(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createBankAccount(int id) {
          BankAccount bankAccount = new BankAccount(id);

        try {
            if(bankAccountDAO.save(bankAccount)) {

                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }


}
