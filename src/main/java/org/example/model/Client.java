package org.example.model;

import java.util.ArrayList;

public class Client {

    private int id;
    private String firstName;
    private String lastName;
    private String numPhone;
    private ArrayList<BankAccount> BankAccounts;

    public Client(int id, String firstName, String lastName, String numPhone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.numPhone = numPhone;
    }

    public Client(String firstName, String lastName, String numPhone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numPhone = numPhone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumPhone() {
        return numPhone;
    }

    public void setNumPhone(String numPhone) {
        this.numPhone = numPhone;
    }

    public ArrayList<BankAccount> getBankAccounts() {
        return BankAccounts;
    }

    public void setBankAccounts(ArrayList<BankAccount> bankAccounts) {
        BankAccounts = bankAccounts;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", numPhone='" + numPhone + '\'' +
                '}';
    }
}
