package c_010_inflearn.i_007_Recursive_Tree_Graph_DFS_BFS_기초.i_007_013_경로탐색_인접리스트_ArrayList;

import java.util.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72777?tab=curriculum

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
    static int[] ch;

    static int answer;

    static ArrayList<ArrayList<Integer>> graph;

    public void DFS(int v) {
        if (v == n) answer++;
        else {
            for (int nv : graph.get(v)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        ch = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
        }

//        System.out.println(graph.toString());

        ch[1] = 1;
        T.DFS(1);
        System.out.print(answer);
    }
}
