package e_031_프로그래머스_고득점킷.g_016_탐욕법그리디;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42861

4
[[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]
정답 : 4


4
5
0 1 1
0 2 2
1 2 5
1 3 1
2 3 8

정답 : 4
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//Solution
public class 섬연결하기_001_크루스칼_최소신장트리_MST_내가푼것 {

    public static class Edge implements Comparable<Edge> {

        int v1;
        int v2;
        int cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge ob) {
            return this.cost - ob.cost;
        }
    }

    static int[] unf;

    public static int Find(int v) {
        if (v == unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }

    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);

        if (fa != fb) unf[fa] = fb;
    }

    public static int solution(int n, int[][] line) {

        int answer = 0;

        int m = line.length;

        unf = new int[n + 1];

        for (int i = 1; i <= n; i++) unf[i] = i;

        ArrayList<Edge> arr = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            arr.add(new Edge(line[i][0], line[i][1], line[i][2]));
        }

//        System.out.println(arr);

        Collections.sort(arr);

        for (int i = 0; i < m; i++) {
            int vfa = Find(arr.get(i).v1);
            int vfb = Find(arr.get(i).v2);

            if (vfa != vfb) {
                answer += arr.get(i).cost;
                Union(arr.get(i).v1, arr.get(i).v2);
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 노드
        int m = Integer.parseInt(br.readLine()); // 간선

        int[][] line = new int[m][3];

        for (int i = 0; i < m; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
            line[i][2] = Integer.parseInt(st.nextToken());
        }

//        System.out.println(Arrays.deepToString(line));

        System.out.println(solution(n, line));
    }
}
