package org.example.model;

public class Operation {

    private int id;
    private float montant;
    private boolean status;

    public Operation (int id, float montant) {
        this.id = id;
        this.montant = montant;
        this.status = false;
    }

    public Operation (float montant) {
        this.montant = montant;
        this.status = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", montant=" + montant +
                ", status=" + status +
                '}';
    }
}
