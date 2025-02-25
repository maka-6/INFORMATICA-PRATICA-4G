package Makaoui_verifica_24_02_2025;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        NumberLists sortedList;
        ArrayList<Integer> inputList = new ArrayList<Integer>();
        int i;
        Scanner sc = new Scanner(System.in);
        int number;
    
        System.out.print("Inserisci 10 numeri:\n->");
        for (i = 0; i < 10; i++) {
            number = sc.nextInt();
            inputList.add(number);
        }

        sortedList = new NumberLists(inputList);
        System.out.println(sortedList.toString());
        System.out.println("[Original List->" + inputList + "]");
    }
}