package e_010_코드업100제;

import java.util.Scanner;

/*
10
10 4 2 3 6 6 7 9 8 5
 */

public class c_1094 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }

        for (int x = n - 1; x >= 0; x--) {

            System.out.print(num[x] + " ");
        }
    }
}
