package e_010_코드업100제;

import java.util.Scanner;

/*
2 2 2
1 2 3
 */

public class c_1084_01_시간초과 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();

        int sum = 0;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                for (int u = 0; u < t; u++) {
                    System.out.println(i + " " + j + " " + u);

                    sum++;
                }

        System.out.print(sum);
    }
}