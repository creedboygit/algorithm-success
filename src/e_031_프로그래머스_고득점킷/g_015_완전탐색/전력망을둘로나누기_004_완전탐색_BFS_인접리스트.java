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
import java.util.*;

//Solution
public class 전력망을둘로나누기_004_완전탐색_BFS_인접리스트 {

    static int bfsNum = 1;

    // bfs에서 연결이 끊긴것을 v1에서 v2로 가는 경우를 제외함으로 해결하였다.
    public static int solution(int n, int[][] wires) {

        int answer = Integer.MAX_VALUE;
        List<List<Integer>> map = new ArrayList<>();

        // 인접 행렬 초기화
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        // 인접 행렬 연결
        for (int[] wire : wires) {
            map.get(wire[0]).add(wire[1]);
            map.get(wire[1]).add(wire[0]);
        }

//        System.out.println(map);

        for (int[] wire : wires) {

            // 연결 끊기
            map.get(wire[0]).remove((Integer)wire[1]);
            map.get(wire[1]).remove((Integer)wire[0]);

            bfs(map, n);

            answer = Math.min(answer, Math.abs((n - bfsNum) - bfsNum));
            bfsNum = 1; // 다시 초기화

            // 연결 다시 원복
            map.get(wire[0]).add(wire[1]);
            map.get(wire[1]).add(wire[0]);
        }

        return answer;
    }

    public static void bfs(List<List<Integer>> map, int n) {

        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];
        visit[1] = true;
        q.add(1);

        while (!q.isEmpty()) {

            List<Integer> list = map.get(q.poll());
            for (int i : list) {
                if (!visit[i]) {
                    q.add(i);
                    visit[i] = true;
                    bfsNum += 1;
                }
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