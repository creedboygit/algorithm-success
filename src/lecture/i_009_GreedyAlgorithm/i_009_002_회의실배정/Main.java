package lecture.i_009_GreedyAlgorithm.i_009_002_회의실배정;

import java.util.*;

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73413?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/09-02

/*
2. 회의실 배정
설명

한 개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의들에 대하여 회의실 사용표를 만들려고 한다.

각 회의에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라.

단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.


입력
첫째 줄에 회의의 수 n(1<=n<=100,000)이 주어진다. 둘째 줄부터 n+1 줄까지 각 회의의 정보가 주어지는데

이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 회의시간은 0시부터 시작한다.

회의의 시작시간과 끝나는 시간의 조건은 (시작시간 <= 끝나는 시간)입니다.


출력
첫째 줄에 최대 사용할 수 있는 회의 수를 출력하여라.



*/

/*
입력1
5
1 4
2 3
3 5
4 6
5 7

출력1
3

입력2
3
3 3
1 3
2 3

출력2
2
*/

class Time implements Comparable<Time> {

    public int s, e;

    Time (int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Time o) {
        if (this.e == o.e) { // 끝 시간이 같다면 시작 시간으로 오름차순 정렬
            return this.s - o.s;
        } else {
            return this.e - o.e;
        }

        // this가 먼저 나오면 오름차순, 나중에 나오면 내림차순
    }
}

public class Main {

    public int solution(int n, ArrayList<Time> times) {

        int answer = 0;

        Collections.sort(times);

        int ep = 0;

        for (Time ob : times) {
            if (ob.s >= ep) {
                answer++;
                ep = ob.e;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> times = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            times.add(new Time(s, e)); // new Time 해주는거 까먹지 말자
        }

        System.out.println(t.solution(n, times));
    }
}
