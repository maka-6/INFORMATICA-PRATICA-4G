package Makaoui_verifica_24_02_2025;
import java.util.ArrayList;

public class NumberLists {

    private ArrayList<Integer> listPerfect = new ArrayList<>();
    private ArrayList<Integer> listPalindrome = new ArrayList<>();
    private int i;
    int temp;

    public NumberLists( ArrayList<Integer> inputList ) {
        populateList(inputList);
    }

    private void populateList(ArrayList<Integer> inputList) {
        for (i = 0; i < inputList.size(); i++) {
            if (isPalindrome(inputList.get(i))) {
                listPalindrome.add(inputList.get(i));
            }
            if (isPerfect(inputList.get(i))) {
                listPerfect.add(inputList.get(i));
            }
        }
    }

    private boolean isPerfect(int number){
        if (number <= 0) return false;
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0){
                sum += i;
            }
        }
        return sum == number;
    }


    private boolean isPalindrome(int number){
        if ( number < 0 ){
            number = number*-1;
        }
        String num = String.valueOf(number);
        return num.charAt(0) == num.charAt(num.length() - 1);
    }

    public ArrayList<Integer> getPrefectList() {
        return listPerfect;
    }

    public ArrayList<Integer> getPalindromeList() {
        return listPalindrome;
    }

    @Override
    public String toString() {
        return "NumberLists [IsPerfect=" + getPrefectList() + ", listPalindrome=" + getPalindromeList() + "]";
    }
}