package c_010_인프런.i_009_GreedyAlgorithm.i_009_003_결혼식;

import java.util.*;

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73414?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/09-03

/*
3. 결혼식
설명

현수는 다음 달에 결혼을 합니다.

현수는 결혼식 피로연을 장소를 빌려 3일간 쉬지 않고 하려고 합니다.

피로연에 참석하는 친구들 N명의 참석하는 시간정보를 현수는 친구들에게 미리 요구했습니다.

각 친구들은 자신이 몇 시에 도착해서 몇 시에 떠날 것인지 현수에게 알려주었습니다.

현수는 이 정보를 바탕으로 피로연 장소에 동시에 존재하는 최대 인원수를 구하여 그 인원을 수용할 수 있는 장소를 빌리려고 합니다. 여러분이 현수를 도와주세요.

만약 한 친구가 오는 시간 13, 가는시간 15라면 이 친구는 13시 정각에 피로연 장에 존재하는 것이고 15시 정각에는 존재하지 않는다고 가정합니다.


입력
첫째 줄에 피로연에 참석할 인원수 N(5<=N<=100,000)이 주어집니다.

두 번째 줄부터 N줄에 걸쳐 각 인원의 오는 시간과 가는 시간이 주어집니다.

시간은 첫날 0시를 0으로 해서 마지막날 밤 12시를 72로 하는 타임라인으로 오는 시간과 가는 시간이 음이 아닌 정수로 표현됩니다.


출력
첫째 줄에 피로연장에 동시에 존재하는 최대 인원을 출력하세요.



*/

/*
입력
5
14 18
12 15
15 20
20 30
5 14

출력
2
*/

class Time implements Comparable<Time> {

    public int time; // public 까먹지 말자
    public char state; // public 까먹지 말자

    Time (int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Time o) {
        // 시간이 같으면 e, s 순으로 오름차순 정렬
        if (this.time == o.time) return this.state - o.state;
        else {
            // 아니면 시간 순으로 오름차순 정렬
            return this.time - o.time;
        }
    }
}

public class Main {

    public int solution(ArrayList<Time> arr) {

        int answer = Integer.MIN_VALUE; // answer 최대값을 구해야 하므로 이걸 MIN_VALUE

        Collections.sort(arr);

//        for (Time t : arr) {
//            System.out.println(t.state + " " + t.time);
//        }

        int count = 0; // 이건 0이어야지

        for (Time ob : arr) {
//            System.out.println(ob.state + " " + ob.time);
            if (ob.state == 'e') count--;
            else count++;

//            System.out.println(count);

            answer = Math.max(answer, count);
        }

//        System.out.println(count);

        return answer;
    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Time> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int sT = sc.nextInt();
            int eT = sc.nextInt();

            arr.add(new Time(sT, 's'));
            arr.add(new Time(eT, 'e'));
        }

        System.out.println(t.solution(arr));
    }
}
