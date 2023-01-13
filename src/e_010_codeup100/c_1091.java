package e_010_codeup100;

import java.util.Scanner;

/*
1 -2 1 8
 */

public class c_1091 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        long a = sc.nextInt();
        long m = sc.nextInt();
        long d = sc.nextInt();
        long n = sc.nextInt();

        for (int i = 1; i < n; i++) {

            a = a * m + d;
        }

        System.out.println(a);
    }
}
