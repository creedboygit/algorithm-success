package e_010_코드업100제;

import java.util.Scanner;

/*
10
1 3 2 2 5 6 7 4 5 9
 */

public class c_1093_02 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] num = new int[24]; // 1부터니깐 배열의 개수 23 + 1 해줘야 한다.

        for (int i = 1; i <= n; i++) {
            int c = sc.nextInt();
            num[c]++;
        }

        for (int j = 1; j <= 23; j++) {
            System.out.print(num[j] + " ");
        }
    }
}
