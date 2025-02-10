package Makaoui_esercitazione_cestino;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestCestino {
    public static void main(String[] args) {

        Cestino trashcanFood = new Cestino( 40  , "Umido", "Marrone", 20);
        Cestino trashcanGlass = new Cestino();

        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader key = new BufferedReader(in);

        int capacity;
        String type;
        String color;
        int level;
        Cestino trashcanUser;

        try {
            System.out.println("Inserisci il tipo: ");
            type = key.readLine();
            System.out.println("Inserisci il colore: ");
            color = key.readLine();
            System.out.println("Inserisci una capacita: ");
            capacity = Integer.parseInt(key.readLine());
            System.out.println("Inserisci un livello: ");
            level = Integer.parseInt(key.readLine());
            trashcanUser = new Cestino(capacity, type, color, level);
            System.out.println(trashcanUser.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.print("");
        }

        System.out.println(trashcanGlass.toString());
        System.out.println(trashcanFood.toString());

    }
}