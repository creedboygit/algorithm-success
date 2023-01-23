package c_010_인프런.i_008_DFS_BFS_활용.i_008_005_동전교환;

import java.util.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73400?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/08-05

/*
5. 동전교환
설명

다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?

각 단위의 동전은 무한정 쓸 수 있다.


입력
첫 번째 줄에는 동전의 종류개수 N(1<=N<=12)이 주어진다. 두 번째 줄에는 N개의 동전의 종류가 주어지고,

그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.각 동전의 종류는 100원을 넘지 않는다.


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
출력 설명 : 5 5 5 동전 3개로 거슬러 줄 수 있다.
*/

    static int n, m;
    static int answer = Integer.MAX_VALUE; // 최소값을 구해야 하므로 max로

    public void DFS(int L, int sum, Integer[] arr) {

        if (sum > m) return;
        if (L >= answer) return; // 가장 최소 횟수를 구한 다음에는 다음은 구할 필요가 없으므로

        if (sum == m) {
            answer = Math.min(answer, L); // 최소 동전 갯수를 구하는 것이므로 L 반환
        } else {
            for (int i = 0; i < n; i++) {
                DFS(L + 1, sum + arr[i], arr);
            }
        }
    }


    public static void main(String[] args) throws Exception {

        Main t = new Main();

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Integer[] arr = new Integer[n]; // Collections 적용하려면 primitive형태는 안되고 Integer 객체형으로 선언해줘야 한다
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder()); // 시간복잡도 때문에 타임 리밋 때문에 제일 큰 것부터 내려가야 한다.

//        System.out.println(arr.toString());
//        System.out.println(Arrays.toString(arr));

        m = sc.nextInt();

        t.DFS(0, 0, arr); // 동전개수 L, sum, 배열

        System.out.print(answer);
    }
}
