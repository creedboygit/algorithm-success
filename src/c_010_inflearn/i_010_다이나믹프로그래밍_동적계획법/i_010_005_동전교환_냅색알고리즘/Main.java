package c_010_inflearn.i_010_다이나믹프로그래밍_동적계획법.i_010_005_동전교환_냅색알고리즘;

import java.util.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73425?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/10-05

/*
5. 동전교환(냅색 알고리즘)
설명

다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?

각 단위의 동전은 무한정 쓸 수 있다.


입력
첫 번째 줄에는 동전의 종류개수 N(1<=N<=50)이 주어진다.

두 번째 줄에는 N개의 동전의 종류가 주어지고, 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.

각 동전의 종류는 100원을 넘지 않는다.


출력
첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.



*/

/*
입력
3
1 2 5
15

출력
3

힌트
출력설명 : 5 5 5 동전 3개로 거슬러줄 수 있다.
*/
    static int n, m;
    static int[] dy;

    public int solution(int[] coin) {

        int answer = 0;

        Arrays.fill(dy, Integer.MAX_VALUE);

        dy[0] = 0; // 초기화

        for (int i = 0; i < n; i++) { // 동전의 개수만큼 돌리자
            for (int j = coin[i]; j <= m; j++) {
                dy[j] = Math.min(dy[j], dy[j - coin[i]] + 1);
            }
        }

        return dy[m];
    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        m = sc.nextInt();
        dy = new int[m + 1]; // dy는 1원부터 m원까지므로 +1 해줘서 인덱스를 늘려줘야 한다

        System.out.println(t.solution(arr));
    }
}
