package e_031_프로그래머스_고득점킷.g_018_DFS_BFS;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/84021

game board
[[1,1,0,0,1,0],[0,0,1,0,1,0],[0,1,1,0,0,1],[1,1,0,1,1,1],[1,0,0,0,1,0],[0,1,1,1,0,0]]

table
[[1,0,0,1,1,0],[1,0,1,0,1,0],[0,1,1,0,1,1],[0,0,1,0,0,0],[1,1,0,1,1,0],[0,1,0,0,0,0]]

정답 : 14

game board
[[0,0,0],[1,1,0],[1,1,1]]

table
[[1,1,1],[1,0,0],[0,0,0]]

정답 : 0


6 6
1 1 0 0 1 0
0 0 1 0 1 0
0 1 1 0 0 1
1 1 0 1 1 1
1 0 0 0 1 0
0 1 1 1 0 0

1 0 0 1 1 0
1 0 1 0 1 0
0 1 1 0 1 1
0 0 1 0 0 0
1 1 0 1 1 0
0 1 0 0 0 0

정답 : 14
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//Solution
public class 퍼즐조각채우기_001 {

    private static final int BOARD = 0;
    private static final int TABLE = 1;

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {-1, 0, 1, 0};

    private static boolean result;
    private static List<int[]> posList;

    private static List<int[]> blocks = new ArrayList<>();

    public static int solution(int[][] game_board, int[][] table) {

        int answer = 0;

        doClassification(game_board, BOARD);
        doClassification(table, TABLE);

        for (int y = 0; y < game_board.length; y++) {
            for (int x = 0; x < game_board.length; x++) {
                if (game_board[y][x] != 0) {

                    for (Iterator<int[]> iter = blocks.iterator(); iter.hasNext(); ) {
                        int[] block = iter.next();

                        for (int r = 0; r < 4; r++) {

                            boolean[][] visit = new boolean[game_board.length][game_board.length];
                            result = true;
                            posList = new ArrayList<>();
                            compare(visit, game_board, table, game_board[y][x], table[block[1]][block[0]], x, y, block[0], block[1], r);

                            if (result) {
                                answer += posList.size();
                                for (int[] pos : posList) {
                                    game_board[pos[1]][pos[0]] = 0;
                                    table[pos[3]][pos[2]] = 0;
                                }
                                iter.remove();
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }

    // 게임 보드 0, 1 값 스위칭
    // 각각의 고유한 조각들 판별
    private static void doClassification(int[][] arr, int type) {
        boolean[][] visit = new boolean[arr.length][arr.length];
        int n = 1;

        if (type == BOARD) {
            for (int y = 0; y < arr.length; y++) {
                for (int x = 0; x < arr.length; x++) {
                    arr[y][x] = (arr[y][x] == 1) ? 0 : 1;
                }
            }
        } else if (type == TABLE) {
            for (int y = 0; y < arr.length; y++) {
                for (int x = 0; x < arr.length; x++) {
                    if (!visit[y][x] && arr[y][x] != 0) {
                        blocks.add(new int[]{x, y});
                        find(arr, x, y, n++, visit);
                    }
                }
            }
        }
    }

    private static void find(int[][] arr, int x, int y, int n, boolean[][] visit) {
        if (visit[y][x] || arr[y][x] == 0) return;

        arr[y][x] = n;
        visit[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int _y = y + dy[i];
            int _x = x + dx[i];

            if (_y >= 0 && _y < arr.length && _x >= 0 && _x < arr.length) {
                find(arr, _x, _y, n, visit);
            }
        }
    }

    /**
     * 회전하여 비교 (회전 X => +0)
     * 1. 90도 회전 : 상,좌 / 하,우 / 좌,하 / 우,상 => +1
     * 2. 180도 회전 : 상,하 / 하,상 / 좌,우 / 우,좌 => +2
     * 3. 270도 회전 : 상,우 / 하,좌 / 좌,상 / 우,하 => +3
     */
    private static void compare(boolean[][] visit, int[][] board, int[][] table, int b_zone, int t_zone, int bx, int by, int tx, int ty, int rotate) {
        if (board[by][bx] != b_zone || table[ty][tx] != t_zone) {
            result = false;
            return;
        }
        visit[ty][tx] = true;
        posList.add(new int[]{bx, by, tx, ty});

        for (int i = 0; i < 4; i++) {
            int _by = by + dy[i];
            int _bx = bx + dx[i];

            int _ty = ty + dy[(i + rotate) % 4];
            int _tx = tx + dx[(i + rotate) % 4];

            if (_by >= 0 && _by < board.length && _bx >= 0 && _bx < board.length
                    && ((_ty < 0 || _ty >= board.length) || (_tx < 0 || _tx >= board.length))) {
                if (board[_by][_bx] == b_zone) {
                    result = false;
                    return;
                }
            } else if (_ty >= 0 && _ty < board.length && _tx >= 0 && _tx < board.length
                    && ((_by < 0 || _by >= board.length) || (_bx < 0 || _bx >= board.length))) {
                if (table[_ty][_tx] == t_zone) {
                    result = false;
                    return;
                }
            } else if (_by >= 0 && _by < board.length && _bx >= 0 && _bx < board.length
                    && _ty >= 0 && _ty < board.length && _tx >= 0 && _tx < board.length) {

                if ((board[_by][_bx] == b_zone || table[_ty][_tx] == t_zone) && !visit[_ty][_tx]) {
                    compare(visit, board, table, b_zone, t_zone, _bx, _by, _tx, _ty, rotate);
                } else if (board[_by][_bx] != b_zone && table[_ty][_tx] == t_zone) {
                    result = false;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        int[][] table = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] a = br.readLine().split(" ");

            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(a[j]);
            }
        }

//        System.out.println(Arrays.deepToString(board));

        br.readLine();

        for (int i = 0; i < n; i++) {
            String[] a = br.readLine().split(" ");

            for (int j = 0; j < m; j++) {
                table[i][j] = Integer.parseInt(a[j]);
            }
        }

//        System.out.println(Arays.deepToString(table));

        System.out.println(solution(board, table));
    }
}
