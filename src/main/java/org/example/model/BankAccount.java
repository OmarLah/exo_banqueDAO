package org.example.model;

import java.util.ArrayList;

public class BankAccount {

    private int id;
    private float solde;
    private Client client;
    private ArrayList<Operation> operations;

    public BankAccount(int id, Client client) {
        this.id = id;
        this.solde = 0;
        this.client = client;
    }

    public BankAccount(int id) {
        this.solde = 0;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ArrayList<Operation> getOperations() {
        return operations;
    }

    public void setOperations(ArrayList<Operation> operations) {
        this.operations = operations;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", solde=" + solde +
                ", client=" + client +
                '}';
    }
}
