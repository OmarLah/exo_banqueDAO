package org.example.service;

import org.example.dao.BankAccountDAO;
import org.example.dao.ClientDAO;
import org.example.model.BankAccount;
import org.example.model.Client;
import org.example.util.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ClientService {
    private ClientDAO clientDAO;
    private BankAccountDAO bankAccountDAO;
    private Connection connection;

    public ClientService() {
        try {
            connection = new DatabaseManager().getConnection();
            clientDAO = new ClientDAO(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createClient(String firstName, String lastName, String numPhone) {
        Client client = new Client(firstName, lastName, numPhone);

        try {
            if(clientDAO.save(client)) {

                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean updateClient(Client client) {
        try {
            if(clientDAO.update(client)) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public Client getClient(int id) {
        try {
            return clientDAO.get(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Client getClientByphone(String num) {
        try {
            return clientDAO.getByPhone(num);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteClient(int id) {
        Client client = null;
        try {
            client = clientDAO.get(id);
            if(client != null) {
                return clientDAO.delete(client);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public List<Client> getAllClients() {
        try {
            return clientDAO.get();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
