package session_12.version_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HappyNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(isHappyNumber(num));
        scanner.close();
    }

    private static boolean isHappyNumber(int number) {
        if(number == 1) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        while (true) {
            number = sumOfDigits(number);
            System.out.println(number);
            if(number == 1) {
                return true;
            }
            if(list.contains(number) || list.contains(reverseInteger(number))) {
                return false;
            }
            list.add(number);
        }
    }

    private static int sumOfDigits(int num) {
        int sum = 0;
        while(num != 0) {
            sum += Math.pow(num % 10, 2);
            num /= 10;
        }
        return sum;
    }

    private static int reverseInteger(int num) {
        StringBuilder sb = new StringBuilder(Integer.toString(num));
        sb.reverse();
        return Integer.parseInt(sb.toString());
    }
}
