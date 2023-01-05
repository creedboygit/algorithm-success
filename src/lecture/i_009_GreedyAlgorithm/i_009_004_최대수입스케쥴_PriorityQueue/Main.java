package lecture.i_009_GreedyAlgorithm.i_009_004_최대수입스케쥴_PriorityQueue;

import java.util.*;

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73419?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/09-04

/*
4. 최대 수입 스케쥴(PriorityQueue 응용문제)
설명

현수는 유명한 강연자이다. N개이 기업에서 강연 요청을 해왔다. 각 기업은 D일 안에 와서 강연을 해 주면 M만큼의 강연료를 주기로 했다.

각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.

단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.


입력
첫 번째 줄에 자연수 N(1<=N<=10,000)이 주어지고, 다음 N개의 줄에 M(1<=M<=10,000)과 D(1<=D<=10,000)가 차례로 주어진다.


출력
첫 번째 줄에 최대로 벌 수 있는 수입을 출력한다.



*/

/*
입력
6
50 2
20 1
40 2
60 3
30 3
30 1

출력
150
*/

class Lecture implements Comparable<Lecture> {

    public int money;
    public int date;

    Lecture(int money, int date) {
        this.money = money;
        this.date = date;
    }

    public int compareTo(Lecture o) {
        return o.date - this.date;
    }
}

public class Main {


    static int n, max = Integer.MIN_VALUE;

    public int solution(ArrayList<Lecture> arr) {

        int answer = 0;

        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(arr);

//        for (Lecture l : arr) {
//            System.out.println(l.money + " : " + l.date);
//        }

//        60 : 3
//        30 : 3
//        50 : 2
//        40 : 2
//        20 : 1
//        30 : 1

        int j = 0;

        for (int i = max; i >= 1; i--) {
//            for (j = 0; j < n; j++) {

//            System.out.println("I : " + i);

            for (; j < n; j++) {

//                System.out.println("date : " + arr.get(j).date + " : " + i);

//                System.out.println("J : " + j);

                if (arr.get(j).date < i) {
//                    System.out.println("---------");
                    break;
                }

                pQ.offer(arr.get(j).money);

//                System.out.println(pQ.toString());
            }

            if (!pQ.isEmpty()) {
//                System.out.println("out : " + pQ.poll());
                answer += pQ.poll();
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ArrayList<Lecture> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int money = sc.nextInt();
            int date = sc.nextInt();
            arr.add(new Lecture(money, date));
            if (date > max) max = date;
        }

        System.out.println(t.solution(arr));
    }
}
