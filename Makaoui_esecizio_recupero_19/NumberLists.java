package Makaoui_esecizio_recupero_19;
import java.util.ArrayList;

public class NumberLists {
    private ArrayList<Integer> armstrongList = new ArrayList<>();
    private ArrayList<Integer> primeList = new ArrayList<>();

    public static boolean isArmstrong(int number) {
        int originalNumber = number;
        int sum = 0;
        int numDigits = String.valueOf(number).length();

        while (number > 0) {
            int digit = number % 10;
            sum += (int)Math.pow(digit, numDigits);
            number /= 10;
        }

        return sum == originalNumber;
    }

    public static boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public void populateLists(ArrayList<Integer> numbers) {
        for (int num : numbers) {
            if (isArmstrong(num)) {
                armstrongList.add(num);
            }
            if (isPrime(num)) {
                primeList.add(num);
            }
        }
    }

    public ArrayList<Integer> getArmstrongList() {
        return armstrongList;
    }

    public ArrayList<Integer> getPrimeList() {
        return primeList;
    }
}