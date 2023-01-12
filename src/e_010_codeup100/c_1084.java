package e_010_codeup100;

import java.util.Scanner;

/*
9
 */

public class c_1084 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {

            if (i % 3 == 0) {
                System.out.print("X" + " ");
                continue;
            }

            System.out.print(i + " ");
        }

    }
}
