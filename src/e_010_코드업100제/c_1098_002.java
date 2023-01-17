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

public class c_1098_002 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int height = sc.nextInt();
        int width = sc.nextInt();

        int[][] map = new int[height][width];

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int length = sc.nextInt();
            int direction = sc.nextInt();
            int x = sc.nextInt() - 1; // 미리 -1을 해준다.
            int y = sc.nextInt() - 1; // 미리 -1을 해준다.

            for (int j = 0; j < length; j++) {
                if (direction == 0) // 가로 방향
                    map[x][y + j] = 1;
                else // 세로 방향
                    map[x + j][y] = 1;
            }
        }

        for (int i = 0; i < height; i++) {

            for (int j = 0; j < width; j++)
                System.out.print(map[i][j] + " ");

            System.out.println();
        }
    }
}
