package javaPhase1.coreFunctions.numberLogic;

import java.util.HashMap;

public class countEvenDigitsInNumber {
    public static void main(String[] args) {
        int number = 279;
//        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        while (number > 0) {
            int digit = number % 10;
            map.put(digit, map.getOrDefault(digit, 0) + 1);
//            if (digit % 2 == 0) count++;
            number = number / 10;
        }
        System.out.println(map);
    }
}
