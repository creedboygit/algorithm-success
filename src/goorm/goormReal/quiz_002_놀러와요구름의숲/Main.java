package goorm.goormReal.quiz_002_놀러와요구름의숲;

import java.util.*;
import java.io.*;

/*
H.........
..........
..........
..........
..........
..........
..........
..........
..........
R........M

..........
..........
..........
..H.......
..........
.....R....
..........
..........
.....M....
..........

..........
..........
....M.....
..........
..........
....R.....
..........
..........
....H.....
..........
*/

//좌표 x,y 선언
class Pos {

    public int x;
    public int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    // '.' 와 '#'가 그려질 map을 static으로 선언
    static char[][] map = new char[12][12];

    static Queue<Pos> q = new LinkedList<>();

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int startX;
    static int startY;

    static int endX;
    static int endY;

    public static void bfs() {
        while (!q.isEmpty()) {
            int s = q.size();

            for (int i = 0; i < s; i++) {
                Pos pos = q.poll();

                if (map[pos.x][pos.y] == 'R') {
                    continue;
                }



                for (int j = 0; j < 10; j++) {
                    int nx;
                    int ny;

                    if (startX < startY) {
                        nx = pos.x + dx[j];
                        ny = pos.y + dy[j];
                    } else {
                        nx = pos.x - dx[j];
                        ny = pos.y - dy[j];
                    }

                    System.out.println("nx : " + nx);
                    System.out.println("ny : " + ny);

                    if (nx < 0 || ny < 0 || nx >= 10 || ny >= 10) {
                        continue;
                    }

//                    if (nx == 0 && ny == 7) {
//                        System.out.println(1);
//                        return;
//                    }

                    if (map[nx][ny] != 'R') {
                        q.offer(new Pos(nx, ny));
                    }
                }
            }

//            down();


        }
    }

    public static void down() {
        for (int i = 6; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                map[i + 1][j] = map[i][j];
            }
        }
        for (int i = 0; i < 8; i++) {
            map[0][i] = '.';
        }
    }


    public static void main(String[] args) throws Exception {

        Main t = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            char[] c = br.readLine().toCharArray();
            for (int k = 0; k < 10; k++) {
                char a = map[i][k] = c[k];

                if (a == 'H') {
                    startX = i;
                    startY = k;
                } else if (a == 'M') {
                    endX = i;
                    endY = k;
                }
//                System.out.println(map[i][k]);
            }
        }

//        System.out.println(startX);
//        System.out.println(startY);

//        System.out.println(endX);
//        System.out.println(endY);

        Pos start = new Pos(startX, startY);
        q.offer(start);
        bfs();
    }
}
