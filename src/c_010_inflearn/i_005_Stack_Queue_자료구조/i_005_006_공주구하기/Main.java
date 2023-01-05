package c_010_inflearn.i_005_Stack_Queue_자료구조.i_005_006_공주구하기;

import java.util.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72750?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/05-06

/*
6. 공주 구하기
설명

정보 왕국의 이웃 나라 외동딸 공주가 숲속의 괴물에게 잡혀갔습니다.

정보 왕국에는 왕자가 N명이 있는데 서로 공주를 구하러 가겠다고 합니다.

정보왕국의 왕은 다음과 같은 방법으로 공주를 구하러 갈 왕자를 결정하기로 했습니다.

왕은 왕자들을 나이 순으로 1번부터 N번까지 차례로 번호를 매긴다.

그리고 1번 왕자부터 N번 왕자까지 순서대로 시계 방향으로 돌아가며 동그랗게 앉게 한다.

그리고 1번 왕자부터 시계방향으로 돌아가며 1부터 시작하여 번호를 외치게 한다.

한 왕자가 K(특정숫자)를 외치면 그 왕자는 공주를 구하러 가는데서 제외되고 원 밖으로 나오게 된다.

그리고 다음 왕자부터 다시 1부터 시작하여 번호를 외친다.

이렇게 해서 마지막까지 남은 왕자가 공주를 구하러 갈 수 있다.

Image1.jpg

예를 들어 총 8명의 왕자가 있고, 3을 외친 왕자가 제외된다고 하자. 처음에는 3번 왕자가 3을 외쳐 제외된다.

이어 6, 1, 5, 2, 8, 4번 왕자가 차례대로 제외되고 마지막까지 남게 된 7번 왕자에게 공주를 구하러갑니다.

N과 K가 주어질 때 공주를 구하러 갈 왕자의 번호를 출력하는 프로그램을 작성하시오.


입력
첫 줄에 자연수 N(5<=N<=1,000)과 K(2<=K<=9)가 주어진다.


출력
첫 줄에 마지막 남은 왕자의 번호를 출력합니다.
*/

/*
입력
8 3

출력
7
*/

    public int solution(int n, int k) {

        int answer = 0;

        Queue<Integer> Q = new LinkedList<>(); // 외우자

        for (int i = 1; i <= n; i++) { // i = 1 부터 n 포함까지다
            Q.offer(i);
//            System.out.println(Q.toString());
        }

        while (!Q.isEmpty()) {

            for (int j = 1; j < k; j++) { // j = 1 부터라는거 꼭 명심해라
                Q.offer(Q.poll());
            }
            Q.poll();
            if (Q.size() == 1) answer = Q.poll();
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

        System.out.println(t.solution(n, k));
    }
}
