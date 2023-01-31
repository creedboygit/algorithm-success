package e_031_프로그래머스_고득점킷.g_015_완전탐색;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/86971

9	[[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]	3
4	[[1,2],[2,3],[3,4]]	0
7	[[1,2],[2,7],[3,7],[3,4],[4,5],[6,7]]	1


9
1 3
2 3
3 4
4 5
4 6
4 7
7 8
7 9


정답 : 3

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//Solution
public class 전력망을둘로나누기_002_완전탐색_DFS_인접리스트 {

    static ArrayList<Integer>[] list;
    static int min;
    static boolean[] visited;

    public static int solution(int n, int[][] wires) {

        int answer = -1;

        list = new ArrayList[n + 1];
        min = Integer.MAX_VALUE / 2;

        // 먼저 문제에서 주어진 n과 wires를 활용해 인접리스트를 만들어줬다.
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        // 인접리스트 만들기
        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];

            list[v1].add(v2);
            list[v2].add(v1);
        }

        for (int i = 0; i < wires.length; i++) {

            int v1 = wires[i][0];
            int v2 = wires[i][1];

            visited = new boolean[n + 1];
            visited[1] = true;

            // 인접리스트를 만든 뒤 wires의 크기만큼 반복문을 돌아주고, 각 반복마다 해당되는 v1과 v2를 dfs에 파라미터로 넘겨줬다.
            dfs(1, v1, v2);

            // dfs가 끝나면 visited 배열에 true라고 저장된 송전탑(cnt개)끼리 연결되어있고, false로 저장된 송전탑 끼리 연결되어 있기 때문에 두 그룹의 차이는 |cnt-(n-cnt)|가 된다.
            int cnt = 0;
            for (int j = 1; j < visited.length; j++) {
                if (visited[j]) cnt++;
            }

            min = Math.min(min, Math.abs(n - (2 * cnt)));
        }

        answer = min;

        return answer;
    }

    static void dfs(int n, int v1, int v2) {

        for (int num : list[n]) {

            if ((n == v1 && num == v2) || (n == v2 && num == v1)) continue; // dfs에서 현재 송전탑과 인접리스트에 있는 송전탑이 v1, v2인 경우는 건너뛰고

            if (!visited[num]) { // 인접리스트에 있는 송전탑이 아직 방문하지 않은(연결되지 않은) 송전탑이라면 dfs를 계속 실행시킨다.

                visited[num] = true;
                dfs(num, v1, v2);
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = n - 1;

        int[][] wires = new int[k][2];

        for (int i = 0; i < k; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            wires[i][0] = Integer.parseInt(st.nextToken());
            wires[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, wires));
    }
}