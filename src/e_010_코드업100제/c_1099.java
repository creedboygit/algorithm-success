package e_010_코드업100제;

import java.util.Arrays;
import java.util.Scanner;

/*
1 1 1 1 1 1 1 1 1 1
1 0 0 1 0 0 0 0 0 1
1 0 0 1 1 1 0 0 0 1
1 0 0 0 0 0 0 1 0 1
1 0 0 0 0 0 0 1 0 1
1 0 0 0 0 1 0 1 0 1
1 0 0 0 0 1 2 1 0 1
1 0 0 0 0 1 0 0 0 1
1 0 0 0 0 0 0 0 0 1
1 1 1 1 1 1 1 1 1 1


1 1 1 1 1 1 1 1 1 1
1 9 9 1 0 0 0 0 0 1
1 0 9 1 1 1 0 0 0 1
1 0 9 9 9 9 9 1 0 1
1 0 0 0 0 0 9 1 0 1
1 0 0 0 0 1 9 1 0 1
1 0 0 0 0 1 9 1 0 1
1 0 0 0 0 1 0 0 0 1
1 0 0 0 0 0 0 0 0 1
1 1 1 1 1 1 1 1 1 1
 */

public class c_1099 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] map = new int[11][11];

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                map[i][j] = sc.nextInt();
            }
        }

//        System.out.print(Arrays.deepToString(map));

        int x = 2; // 초기화
        int y = 2; // 초기화

        if (map[x][y] == 0) {
            map[x][y] = 9; // 초기화
        }

        while (true) {

            if (x == 10 && y == 10) { // 오른쪽 맨 아래로 구석으로 갔다면 끝
                break;
            }

            if (map[x][y] == 2) { // 2를 만나면 먹이이므로 멈춤
                map[x][y] = 9;
                break;
            }

            if (map[x][y + 1] == 0) { // 오른쪽이 0이면 갈 수 있다.
                y++; // 오른쪽으로 이동
                map[x][y] = 9; // 자취 남기기
                continue;
            }

            if (map[x][y + 1] == 1) { // 오른쪽이 벽으로 막혀있으면

                if (map[x + 1][y] == 0) { // 아래로 갈 수 있다면

                    x++; // 아래로 이동
                    map[x][y] = 9;
                    continue;
                }

                if (map[x + 1][y] == 1) { // 아래가 벽으로 막혀있다면 오른쪽도 막히고 아래도 막히므로 멈춤
                    break;
                }

                if (map[x + 1][y] == 2) { // 아래가 먹이라면
                    x++;
                    map[x][y] = 9;
                    break;
                }
            }
        }

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
