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

public class c_1098_003 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int h = scanner.nextInt();
        int w = scanner.nextInt();

        int[][] a = new int[h + 1][w + 1];

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {

            int l = scanner.nextInt();
            int d = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            for (int j = 0; j < l; j++) {
                if (d == 0)
                    a[x][y + j] = 1;
                else
                    a[x + j][y] = 1;
            }
        }

        for (int s = 1; s <= h; s++) {
            for (int t = 1; t <= w; t++)
                System.out.print(a[s][t] + " ");
            System.out.println();
        }
    }
}
