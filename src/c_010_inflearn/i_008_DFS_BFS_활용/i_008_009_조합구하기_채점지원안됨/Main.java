package c_010_inflearn.i_008_DFS_BFS_활용.i_008_009_조합구하기_채점지원안됨;

import java.util.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73404?tab=curriculum

//

/*

*/

/*
입력
4 2

출력
1 2
1 3
1 4
2 3
2 4
3 4
*/

    static int n, m;
    static int[] combi;

    public void DFS(int L, int start) {
        if (L == m) {
            for (int x : combi) System.out.print(x + " ");
            System.out.println();
        } else {
            for (int i = start; i <= n; i++) {
                combi[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        combi = new int[m];

        t.DFS(0, 1); // L, start 숫자
    }
}
