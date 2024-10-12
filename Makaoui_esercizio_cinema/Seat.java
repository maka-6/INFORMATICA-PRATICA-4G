package Makaoui_esercizio_cinema;

public class Seat {

    private char row;
    private int number;
    private boolean available;
    private boolean isVip;
    private double price;

    public Seat() {
        this.available = true;
    }

    public Seat(char row, int number, boolean available, boolean isVip, double price) {
        this.row = row;
        this.number = number;
        this.available = available;
        this.isVip = isVip;
        this.price = price;
    }

    public char getRow() {
        return row;
    }
    public int getNumber() {
        return number;
    }
    public boolean isAvailable() {
        return available;
    }
    public boolean isVip() {
        return isVip;
    }

    // Metodo per occupare il posto
    public void occupy() {
        if (available) {
            available = false;
            System.out.println("Il posto " + row + number + " è stato occupato.");
        } else {
            System.out.println("Il posto " + row + number + " è già occupato.");
        }
    }

    // Metodo per liberare il posto
    public void free() {
        if (!available) {
            available = true;
            System.out.println("Il posto " + row + number + " è stato liberato.");
        } else {
            System.out.println("Il posto " + row + number + " è già libero.");
        }
    }

    // Metodo per stampare le informazioni del posto
    public void printSeatInfo() {
        String vipStatus = isVip ? "VIP" : "Base";
        String availability = available ? "Libero" : "Occupato";
        System.out.println("Posto: " + row + number + " | " + vipStatus + " " + availability + " " + price + "$");
    }
}