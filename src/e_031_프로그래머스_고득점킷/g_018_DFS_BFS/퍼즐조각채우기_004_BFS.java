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
public class 퍼즐조각채우기_004_BFS {

    public static ArrayList<int[][]> game, tab; // game_board 와 tab을 조각별로 저장
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    // extract blocks -> game, tab


    public static int solution(int[][] game_board, int[][] table) {

        int answer = 0;
        game = new ArrayList<>();
        tab = new ArrayList<>();
        // game_board 블록 추출
        boolean[][] vtd = new boolean[game_board.length][game_board[0].length];
        for (int i = 0; i < game_board.length; i++) {
            for (int j = 0; j < game_board[i].length; j++) {
                if (!vtd[i][j] && game_board[i][j] == 0) {
                    extract(game_board, 0, i, j, vtd);
                }
            }
        }

        // table 블록 추출
        vtd = new boolean[table.length][table[0].length];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (!vtd[i][j] && table[i][j] == 1) {
                    extract(table, 1, i, j, vtd);
                }
            }
        }

        //game, tab 매치 체크
        boolean[] used = new boolean[tab.size()];
        for (int i = 0; i < game.size(); i++) {
            for (int j = 0; j < tab.size(); j++) {
                if (!used[j]) {
                    int ans = match(i, j, used);
                    answer += ans;
                    if (ans > 0) break;
                }
            }
        }

        return answer;

    }

    public static void extract(int[][] arr, int flag, int x, int y, boolean[][] vtd) { // flag == 0 : game, flag == 1 : tab
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        vtd[x][y] = true;
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[]{x, y});
        // 블록 추출하기
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int cx = tmp[0];
            int cy = tmp[1];

            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr.length || vtd[nx][ny] || arr[nx][ny] != flag)
                    continue;
                else {
                    vtd[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    list.add(new int[]{nx, ny});
                }
            }
        }

        int xmin = 987654321;
        int xmax = -987654321;
        int ymin = 987654321;
        int ymax = -987654321;
        // 추출한 블록 기준, x, y 각각 min, max 값 구하기
        for (int i = 0; i < list.size(); i++) {
            xmin = Math.min(list.get(i)[0], xmin);
            xmax = Math.max(list.get(i)[0], xmax);
            ymin = Math.min(list.get(i)[1], ymin);
            ymax = Math.max(list.get(i)[1], ymax);
        }

        int[][] temp = new int[xmax - xmin + 1][ymax - ymin + 1];
        // 2차원 배열에 추출한 븝록 넣기
        for (int[] ints : list) {
            ints[0] -= xmin;
            ints[1] -= ymin;
            temp[ints[0]][ints[1]] = 1;
        }
        // flag == 0 -> game, flag == 1 -> tab
        if (flag == 0) Collections.addAll(game, temp);
        else Collections.addAll(tab, temp);
    }

    // rotate
    public static boolean rotate(int game_idx, int table_idx) {
        // 배열을 돌리기 전에 같으면 바로 true 넘기기
        if (Arrays.deepEquals(game.get(game_idx), tab.get(table_idx))) return true;

        //rotate 90도 시계방향으로 3번 진행
        int[][] tmp = tab.get(table_idx);

        for (int pp = 0; pp < 3; pp++) {
            int[][] rot = new int[tmp[0].length][tmp.length];
            for (int i = 0; i < tmp.length; i++) {
                for (int j = 0; j < tmp[i].length; j++) {
                    // ex. tmp (0, 1) -> rot (1, rot[j].length - i - 1)
                    // x, y 값 위치 바꾸고 새로운 y값은 계산
                    rot[j][rot[j].length - i - 1] = tmp[i][j];
                }
            }
            // 맞으면 바로 true 아니면 회전에서 계속 체크
            if (Arrays.deepEquals(game.get(game_idx), rot)) return true;
            tmp = rot;
        }
        return false;
    }

    // match 체크
    public static int match(int game_idx, int table_idx, boolean[] used) {
        int count = 0;
        // false면 매치 불가
        if (!rotate(game_idx, table_idx)) return 0;
        // match 가능하면, 블록 칸 수 세기
        int[][] temp = game.get(game_idx);
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if (temp[i][j] == 1) count++;
            }
        }
        // 사용한 부분 체크
        used[table_idx] = true;
        return count;
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
