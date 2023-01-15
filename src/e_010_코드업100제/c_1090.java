package e_010_코드업100제;

import java.util.Scanner;

/*
2 3 7
 */

public class c_1090 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        long a = sc.nextInt();
        long d = sc.nextInt();
        long n = sc.nextInt();

        for (int i = 1; i < n; i++) {

            a *= d;
        }

        System.out.println(a);
    }
}
