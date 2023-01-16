package e_010_코드업100제;

import java.util.Scanner;

/*
11
10 4 2 3 6 6 7 9 8 5 1
 */

public class c_1095 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }

        int INF = Integer.MAX_VALUE;
        int answer = INF;
        for (int i = 0; i < n; i++) {

            answer = Math.min(num[i], answer);
        }

        System.out.println(answer);
    }
}
