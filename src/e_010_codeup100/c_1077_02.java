package e_010_codeup100;

import java.util.Scanner;

/*
4
 */

public class c_1077_02 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a = 0;

        do {
            System.out.println(a++);
        } while (a <= n);

        sc.close();
    }
}