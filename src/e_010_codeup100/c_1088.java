package e_010_codeup100;

import java.util.Scanner;

/*
10
 */

public class c_1088 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {

            if (i % 3 == 0) continue;

            System.out.print(i + " ");
        }
    }
}
