package lecture.i_008_DFS_BFS_활용.i_008_002_바둑이승차;

import java.util.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73397?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/08-02

/*
2. 바둑이 승차(DFS)
설명

철수는 그의 바둑이들을 데리고 시장에 가려고 한다. 그런데 그의 트럭은 C킬로그램 넘게 태울수가 없다.

철수는 C를 넘지 않으면서 그의 바둑이들을 가장 무겁게 태우고 싶다.

N마리의 바둑이와 각 바둑이의 무게 W가 주어지면, 철수가 트럭에 태울 수 있는 가장 무거운 무게를 구하는 프로그램을 작성하세요.


입력
첫 번째 줄에 자연수 C(1<=C<=100,000,000)와 N(1<=N<=30)이 주어집니다.

둘째 줄부터 N마리 바둑이의 무게가 주어진다.


출력
첫 번째 줄에 가장 무거운 무게를 출력한다.



*/

/*
입력
259 5
81
58
42
33
61

출력
242
*/
    static int answer = Integer.MIN_VALUE; // 최대값 구해야 하므로 min
    static int sum, c, n; // 전역 static으로 선언해야 함

    public void DFS(int L, int sum, int[] arr) {
        if (sum > c) return;
        if (L == n) { // 한 부분집합이 완성되면
            answer = Math.max(answer, sum);
        } else {
            DFS(L + 1, sum + arr[L], arr); // 왼쪽 노드
            DFS(L + 1, sum, arr); // 오른쪽 노드
        }
    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();

        Scanner sc = new Scanner(System.in);
        c = sc.nextInt(); // 위에서 static으로 선언해준 것 이용해야 한다! 주의!
        n = sc.nextInt(); // 위에서 static으로 선언해준 것 이용해야 한다! 주의!

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        t.DFS(0, 0, arr);
        System.out.print(answer);
    }
}
