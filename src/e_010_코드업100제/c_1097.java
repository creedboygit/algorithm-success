package e_010_코드업100제;

import java.util.Scanner;

/*
0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0
2
10 10
12 12
 */

public class c_1097 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] a = new int[20][20];

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                a[i][j] = scanner.nextInt();
            }
        }

        int n = scanner.nextInt();
        int x, y = 0;

        for (int i = 0; i < n; i++)
        {
            x = scanner.nextInt();
            for (int j = 0; j < 19; j++)
            {
                if(a[x - 1][j] == 0)
                {
                    a[x - 1][j] = 1;
                }
                else
                {
                    a[x - 1][j] = 0;
                }
            }
            y = scanner.nextInt();
            for (int j = 0; j < 19; j++) {
                if (a[j][y - 1] == 0) {
                    a[j][y - 1] = 1;
                } else {
                    a[j][y - 1] = 0;
                }
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
