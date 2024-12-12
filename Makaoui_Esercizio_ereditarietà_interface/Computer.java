package Makaoui_Esercizio_ereditarietà_interface;



public class Computer implements Ram, Ssd{

    private String name;
    private int serialNumber;
    private int price;

    // main memory
    private int memory;

    // on/off
    private boolean status;

}