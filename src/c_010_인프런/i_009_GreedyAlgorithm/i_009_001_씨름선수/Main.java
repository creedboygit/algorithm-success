package c_010_인프런.i_009_GreedyAlgorithm.i_009_001_씨름선수;

import java.util.*;

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73412?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/09-01

/*
1. 씨름 선수
설명

현수는 씨름 감독입니다. 현수는 씨름 선수를 선발공고를 냈고, N명의 지원자가 지원을 했습니다.

현수는 각 지원자의 키와 몸무게 정보를 알고 있습니다.

현수는 씨름 선수 선발 원칙을 다음과 같이 정했습니다.

“A라는 지원자를 다른 모든 지원자와 일대일 비교해서 키와 몸무게 모두 A지원자 보다 높은(크고, 무겁다) 지원자가

존재하면 A지원자는 탈락하고, 그렇지 않으면 선발된다.”

N명의 지원자가 주어지면 위의 선발원칙으로 최대 몇 명의 선수를 선발할 수 있는지 알아내는 프로그램을 작성하세요.


입력
첫째 줄에 지원자의 수 N(5<=N<=30,000)이 주어집니다.

두 번째 줄부터 N명의 흰돌 능력치와 검은돌 능력치 정보가 차례로 주어집니다.

각 선수의 흰돌능력치가 모두 다르고, 검은돌 능력치도 모두 다릅니다. 능력치 값은 1,000,000이하의 자연수입니다.


출력
첫째 줄에 바둑 선수로 뽑히는 최대 인원을 출력하세요.



*/

/*
입력
5
172 67
183 65
180 70
170 72
181 60

출력
3
*/

// 좌표정렬 방법 - 외워라
class Body implements Comparable<Body> {
    public int h, w;

    Body(int h, int w) {
        this.h = h;
        this.w = w;
    }


    @Override
    public int compareTo(Body o) {
        return o.h - this.h; // 이건 역순 - 외워라
        // this가 앞에 있으면 오름차순, this가 뒤에 있으면 내림차순
    }
}

public class Main {

    public int solution(ArrayList<Body> body, int n) {

        int answer = 0;

        // 키로 역순 정렬해놓고 몸무게가 max가 나올 때마다 answer++
        Collections.sort(body); // 키(h) 역순 정렬


        int max = Integer.MIN_VALUE;

        for (Body ob : body) {
            if (ob.w > max) {
                answer++;
                max = ob.w;
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

        ArrayList<Body> body = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            body.add(new Body(h, w)); // new Body로 생성해야 한다. 까먹지 말자
        }

        System.out.println(t.solution(body, n));
    }
}
