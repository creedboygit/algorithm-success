package e_010_코드업100제;

import java.util.Scanner;

/*
11
10 4 2 3 6 6 7 9 8 5 1
 */

public class c_1095_003 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] num = new int[n];

        int min = 23;

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();

            if (a < min)
                min = a;
        }

        System.out.println(min);
    }
}
