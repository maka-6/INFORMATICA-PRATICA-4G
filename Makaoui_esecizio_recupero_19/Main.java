package Makaoui_esecizio_recupero_19;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Inserisci numeri separati da spazio (digita 'fine' per terminare):");
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                numbers.add(scanner.nextInt());
            } else {
                String input = scanner.next();
                if (input.equalsIgnoreCase("fine")) break;
            }
        }

        NumberLists numberLists = new NumberLists();
        numberLists.populateLists(numbers);

        System.out.println("Numeri di Armstrong trovati: " + numberLists.getArmstrongList());
        System.out.println("Numeri primi trovati: " + numberLists.getPrimeList());
    }
}