package session_12.version_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;

public class HappyNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        ISumDigit sumDigit = (n) -> {
            int sum = 0;
            while (n != 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            return sum;
        };

        IReverseInteger reverseInteger = (n) -> {
            StringBuilder sb = new StringBuilder(Integer.toString(num));
            return Integer.parseInt(sb.reverse().toString());
        };

        BiPredicate<List<Integer>, Integer> contains = List::contains;

        IHappyNumber happyNumber = (n) -> {
            List<Integer> list = new ArrayList<>();
            while (true) {
                n = sumDigit.sumDigits(n);
                if (n == 1) {
                    return true;
                }
                if (contains.test(list, n)
                        || contains.test(list, reverseInteger.reverseInteger(n))) {
                    return false;
                }
                list.add(n);
            }
        };
        System.out.println(happyNumber.isHappyNumber(num));
        scanner.close();
    }
}