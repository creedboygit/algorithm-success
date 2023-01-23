package c_010_인프런.i_010_다이나믹프로그래밍_동적계획법.i_010_003_최대부분증가수열_LIS;

import java.util.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73423?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/10-03

/*
3. 최대 부분 증가수열
설명

N개의 자연수로 이루어진 수열이 주어졌을 때, 그 중에서 가장 길게 증가하는(작은 수에서 큰 수로) 원소들의 집합을 찾는 프로그램을 작성하라.

예를 들어, 원소가 2, 7, 5, 8, 6, 4, 7, 12, 3 이면 가장 길게 증가하도록 원소들을 차례대로 뽑아내면 2, 5, 6, 7, 12를 뽑아내어

길이가 5인 최대 부분 증가수열을 만들 수 있다.


입력
첫째 줄은 입력되는 데이터의 수 N(3≤N≤1,000, 자연수)를 의미하고,

둘째 줄은 N개의 입력데이터들이 주어진다.


출력
첫 번째 줄에 부분증가수열의 최대 길이를 출력한다.



*/

/*
입력
8
5 3 7 8 6 2 9 4

출력
4
*/

    public int solution(int[] arr) {

        int answer = 0;

        int[] dy = new int[arr.length];

        dy[0] = 1; // 1로 초기화 해준다. 너무 명확하므로

        for (int i = 1; i < arr.length; i++) {
            int max = 0; // 최대값 초기화 0으로 해야 한다. 최소 1이 되어야 하므로

            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && dy[j] > max) max = dy[j];
            }

            dy[i] = max + 1; // +1해주는거 까먹지 말자
            answer = Math.max(answer, dy[i]);
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(t.solution(arr));
    }
}
