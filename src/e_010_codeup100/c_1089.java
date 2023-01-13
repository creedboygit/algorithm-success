package e_010_codeup100;

import java.util.Scanner;

/*
1 3 5
 */

public class c_1089 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int d = sc.nextInt();
        int n = sc.nextInt();

        for (int i = 1; i < n; i++) {

            a += d;
        }

        System.out.println(a);
    }
}
