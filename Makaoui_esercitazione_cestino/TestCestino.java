package Makaoui_esercitazione_cestino;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TestCestino {
    public static void main(String[] args) {

        Cestino trashcanFood = new Cestino( 40  , "Umido", "Marrone", 20);
        Cestino trashcanGlass = new Cestino();

        ArrayList<Cestino> cestino = new ArrayList<Cestino>();
        cestino.add(trashcanFood);
        cestino.add(trashcanGlass);

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
            cestino.add(trashcanUser);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.print("");
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (Cestino c : cestino) {
            System.out.println(c.toString());
            stringBuilder.append(c.toString());
            stringBuilder.append("\n");
        }

    }
}