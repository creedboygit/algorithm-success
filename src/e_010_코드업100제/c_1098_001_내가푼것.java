package e_010_코드업100제;

import java.util.Scanner;

/*
5 5
3
2 0 1 1
3 1 2 3
4 1 2 5


1 1 0 0 0
0 0 1 0 1
0 0 1 0 1
0 0 1 0 1
0 0 0 0 1
 */

public class c_1098_001_내가푼것 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int mak = sc.nextInt();
        int[][] arr = new int [n + 1][m + 1];

        for (int k = 0; k < mak; k++) {
            int len = sc.nextInt();
            int direction = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

//            arr[x][y] = 1;

            for (int l = 0; l < len; l++) {
                if (direction == 0) {
                    arr[x][y + l] = 1;
                } else {
                    arr[x + l][y] = 1;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                System.out.print(arr[i][j] + " ");
            }

            System.out.println();
        }


    }
}
