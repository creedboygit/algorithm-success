package e_010_codeup100;

import java.util.Scanner;

//1 2 4

public class c_1065 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();

        if (a % 2 == 0) {
            System.out.println(a);
        }

        if (b % 2 == 0) {
            System.out.println(b);
        }

        if (c % 2 == 0) {
            System.out.println(c);
        }

        sc.close();
    }
}
