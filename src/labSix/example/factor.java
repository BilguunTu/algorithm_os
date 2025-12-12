package labSix.example;

import java.util.Scanner;

public class factor {

    public static int factorial(int n) {

        if (n < 0) {
            throw new IllegalArgumentException();
        } else if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }

    }

    public static void main(String[] arg) {
        int n;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter positive number: ");
        n = scan.nextInt();
        scan.close();
        System.out.println(n + "! = " + factorial(n));
    }

}
