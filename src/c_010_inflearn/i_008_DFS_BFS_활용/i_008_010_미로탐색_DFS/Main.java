package c_010_inflearn.i_008_DFS_BFS_활용.i_008_010_미로탐색_DFS;

import java.util.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73405?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/08-10

/*
10. 미로탐색(DFS)
설명

7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요.

출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 통로이다.

격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면

Image1.jpg

위의 지도에서 출발점에서 도착점까지 갈 수 있는 방법의 수는 8가지이다.


입력
7*7 격자판의 정보가 주어집니다.


출력
첫 번째 줄에 경로의 가지수를 출력한다.



*/

/*
입력
0 0 0 0 0 0 0
0 1 1 1 1 1 0
0 0 0 1 0 0 0
1 1 0 1 0 1 1
1 1 0 0 0 0 1
1 1 0 1 1 0 0
1 0 0 0 0 0 0

출력
8
*/

    static int[][] board;
    static int answer = 0;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public void DFS(int x, int y) {
        if (x == 7 && y == 7) answer++;
        else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    DFS(nx, ny);
                    board[nx][ny] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

        Scanner sc = new Scanner(System.in);
        board = new int[8][8]; // 배열은 0부터 시작하지만 이 문제는 1부터 시작하므로 -> 꼭 하나 더 해줘야 한다. 까먹지 말자

        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                board[i][j] = sc.nextInt();
                System.out.print(board[i][j]);
            }
        }
        board[1][1] = 1;
        t.DFS(1, 1);

        System.out.println(answer);
    }
}
