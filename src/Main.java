import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }

    /**
     *
     * @param n - The nth term of a fibonacci sequence
     * @return The remainder of the sum of all numbers in fibonacci sequence divided by 10
     */
    private static BigInteger getFibonacciSumFast(long n){
        // create 1D array
        if (n <= 1) {
            return BigInteger.valueOf(n);
        } else {
            BigInteger[] array = new BigInteger[(int)n + 1];
            array[0] = BigInteger.valueOf(0);
            array[1] = BigInteger.valueOf(1);
            BigInteger sum = BigInteger.valueOf(1); // to calculate the sum - sum is 1 currently because 0 + 1 = 1
            for(int i = 2; i < array.length; ++i) {
                array[i] = array[i - 2].add(array[i - 1]);
                sum = sum.add(array[i]);
            }
            return sum.mod(BigInteger.valueOf(10));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        BigInteger s = getFibonacciSumFast(n);
        System.out.println(s);
    }
}