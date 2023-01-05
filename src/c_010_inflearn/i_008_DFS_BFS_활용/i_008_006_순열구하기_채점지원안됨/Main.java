package c_010_inflearn.i_008_DFS_BFS_활용.i_008_006_순열구하기_채점지원안됨;

import java.util.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73401?tab=curriculum

//

/*

*/

/*
입력
3 2
3 6 9

출력
3 6
3 9
6 3
6 9
9 3
9 6
*/

    static int n, m;
    static int[] ch, pm, arr; // arr도 static 전역으로 넣었다

    public void DFS(int L) {

        if (L == m) {
            for (int x : pm) {
                System.out.print(x + " ");
            }

            System.out.println();

        } else {

            for (int i = 0; i < n; i++) { // 3갈래로 뻗어 나가야 한다
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[L] = arr[i];
                    DFS(L + 1);
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

        arr = new int[n]; // arr도 static 전역으로 넣었다
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        ch = new int[n];
        pm = new int[m];

        t.DFS(0); // L 레벨을 매개변수로
    }
}
