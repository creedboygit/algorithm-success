package c_010_인프런.i_004_HashMap_TreeSet_해쉬_정렬지원_Set.i_004_005_K번째큰수_TreeSet;

import java.util.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72743?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/04-05

/*
5. K번째 큰 수
설명

현수는 1부터 100사이의 자연수가 적힌 N장의 카드를 가지고 있습니다. 같은 숫자의 카드가 여러장 있을 수 있습니다.

현수는 이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록하려고 합니다. 3장을 뽑을 수 있는 모든 경우를 기록합니다.

기록한 값 중 K번째로 큰 수를 출력하는 프로그램을 작성하세요.

만약 큰 수부터 만들어진 수가 25 25 23 23 22 20 19......이고 K값이 3이라면 K번째 큰 값은 22입니다.


입력
첫 줄에 자연수 N(3<=N<=100)과 K(1<=K<=50) 입력되고, 그 다음 줄에 N개의 카드값이 입력된다.


출력
첫 줄에 K번째 수를 출력합니다. K번째 수가 존재하지 않으면 -1를 출력합니다.
*/

/*
입력
10 3
13 15 34 23 45 65 33 11 26 42

출력
143
*/

    public int solution(int n, int k, int[] arr) {

        int answer = -1;

//        TreeSet<Integer> tset = new TreeSet<>();
        TreeSet<Integer> tset = new TreeSet<>(Collections.reverseOrder());

        // 카드를 3개를 뽑아야 하니깐 3중 for문 돈다
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { // j = i + 1 해주는거 잊지말자
                for (int m = j + 1; m < n; m++) { // m = j + 1 해주는거 잊지 말자
                    tset.add(arr[i] + arr[j] + arr[m]);
                }
            }
        }

        int cnt = 0;

        //tset.remove(143);
        //System.out.println("size = " + tset.size());
        System.out.println("first = " + tset.first());
        System.out.println("last = " + tset.last());

        for (int x : tset) {
            cnt++;
//            System.out.println(cnt + " : " + x);
            if (cnt == k) return x;
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(t.solution(n, k, arr));
    }
}
