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
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//Solution
public class 전력망을둘로나누기_001_완전탐색_BFS {

    static int arr[][];

    public static int solution(int n, int[][] wires) {

        //        System.out.println(Arrays.deepToString(lines));

        int answer = n; // n으로 초기화

        arr = new int[n + 1][n + 1]; // 1부터 시작이고 인덱스 번호를 써야 하므로 n + 1

        // 1. 인접 행렬에 input
        for (int i = 0; i < wires.length; i++) {

            int n1 = wires[i][0];
            int n2 = wires[i][1];

            arr[n1][n2] = arr[n2][n1] = 1; // 양방향이므로 모두 1로 초기화
        }

        //        System.out.println(Arrays.toString(arr));

        // 2. 선을 하나씩 끊어보면서 순회 (1 -> 0으로 하는 것이 선을 끊는 것)
        int a, b;
        for (int i = 0; i < wires.length; i++) {
            a = wires[i][0];
            b = wires[i][1];

            // 선을 하나 끊고
            arr[a][b] = 0;
            arr[b][a] = 0;

            // BFS
            answer = Math.min(answer, bfs(n, a));

            // 선 다시 복구 이어주기
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        return answer;
    }

    public static int bfs(int n, int start) {

        boolean[] visit = new boolean[n + 1];
        int cnt = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()) {
            int point = queue.poll();
            visit[point] = true;

            for (int i = 1; i <= n; i++) { // point와 연결된 인접한 애들 중에 방문한 적 없는 노드를 큐에 넣고 cnt++
                if (visit[i]) continue;

                if (arr[point][i] == 1) {
                    queue.offer(i);
                    cnt++;
                }

            }
        }

        return Math.abs(cnt - (n - cnt));
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