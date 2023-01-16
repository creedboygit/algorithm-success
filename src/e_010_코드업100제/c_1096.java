package e_010_코드업100제;

import java.util.Scanner;

/*
5
1 1
2 2
3 3
4 4
5 5
 */

public class c_1096 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[20][20]; // 0으로 초기화

        for (int i = 1; i <= n; i++) {

            int a = sc.nextInt();
            int b = sc.nextInt();

            arr[a][b] = 1;
        }

        for (int i = 1; i <= 19; i++) {
            for (int j = 1; j <= 19; j++) {
                System.out.print(arr[i][j] + " ");
            }

            System.out.println();
        }
    }
}
