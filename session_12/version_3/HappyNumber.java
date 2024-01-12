package session_12.version_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class HappyNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        Function<Integer, Integer> sumDigits = (n) -> {
            int sum = 0;
            while (n != 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            return sum;
        };

        Function<Integer, Integer> reverseInteger = (n) -> {
            StringBuilder sb = new StringBuilder(Integer.toString(num));
            return Integer.parseInt(sb.reverse().toString());
        };

        BiPredicate<List<Integer>, Integer> contains = List::contains;

        Predicate<Integer> happyNumber = (n) -> {
            List<Integer> list = new ArrayList<>();
            while (true){
                n = sumDigits.apply(n);
                if (n == 1) {
                    return true;
                }
                if(contains.test(list, n) ||
                contains.test(list, reverseInteger.apply(n))) {
                    return false;
                }
                list.add(n);
            }
        };
        System.out.println(happyNumber.test(num));
        scanner.close();
    }
}
