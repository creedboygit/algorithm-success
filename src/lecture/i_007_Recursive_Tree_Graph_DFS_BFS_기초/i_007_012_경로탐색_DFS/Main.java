package lecture.i_007_Recursive_Tree_Graph_DFS_BFS_기초.i_007_012_경로탐색_DFS;

import java.util.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72776?tab=curriculum

//

/*

*/

/*
입력
5 9
1 2
1 3
1 4
2 1
2 3
2 5
3 4
4 2
4 5


출력
6
*/

    static int n, m;
    static int answer = 0;

    static int[][] graph;

    static int[] ch;

    public void DFS(int v) {
        if (v == n) answer++;
        else {
            for (int i = 1; i <= n; i++) {
                if (graph[v][i] == 1 && ch[i] == 0) {
                    ch[i] = 1;
                    DFS(i);
                    ch[i] = 0;
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n + 1][n + 1];
        ch = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a][b] = 1;
        }

        ch[1] = 1;
        t.DFS(1);
        System.out.println(answer);



    }
}
