package c_010_인프런.i_008_DFS_BFS_활용.i_008_001_합이같은부분집합;

import java.util.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73396?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/08-01

/*
1. 합이 같은 부분집합(DFS : 아마존 인터뷰)
설명

N개의 원소로 구성된 자연수 집합이 주어지면, 이 집합을 두 개의 부분집합으로 나누었을 때

두 부분집합의 원소의 합이 서로 같은 경우가 존재하면 “YES"를 출력하고, 그렇지 않으면 ”NO"를 출력하는 프로그램을 작성하세요.

둘로 나뉘는 두 부분집합은 서로소 집합이며, 두 부분집합을 합하면 입력으로 주어진 원래의 집합이 되어 합니다.

예를 들어 {1, 3, 5, 6, 7, 10}이 입력되면 {1, 3, 5, 7} = {6, 10} 으로 두 부분집합의 합이 16으로 같은 경우가 존재하는 것을 알 수 있다.


입력
첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.

두 번째 줄에 집합의 원소 N개가 주어진다. 각 원소는 중복되지 않는다.


출력
첫 번째 줄에 “YES" 또는 ”NO"를 출력한다.



*/

/*
입력
6
1 3 5 6 7 10

출력
YES
*/
    static int n; // 어떤 것을 static으로 선언할 지에 따라 결과가 달라진다
    static int total = 0;
    static String answer = "NO";
    boolean flag = false;

    public void DFS(int L, int sum, int[] arr) {

        if (flag) return;
        if (sum > total / 2) return;

        if (L == n) { // 한 부분집합이 완성되면
            if ((total - sum) == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            DFS(L + 1, sum + arr[L], arr);
            DFS(L + 1, sum, arr);
        }
    }


    public static void main(String[] args) throws Exception {

        Main t = new Main();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // int n 으로 하는 것과 static 의 위의 것을 이용하는 것은 결과가 다르다

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }

//        System.out.println(total);

        t.DFS(0, 0, arr);

        System.out.println(answer);
    }
}
