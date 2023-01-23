package c_010_인프런.i_002_Array_1_2차원배열.i_002_002_보이는학생수;

import java.io.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72719?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/02-02

/*
i_002_002_보이는학생수

설명

선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는

선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요. (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)


입력
첫 줄에 정수 N(5<=N<=100,000)이 입력된다. 그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다.


출력
선생님이 볼 수 있는 최대학생수를 출력한다.
*/

/*
입력
8
130 135 148 140 145 150 150 153

출력
5
*/

    public int solution(int n, int[] arr) {

        int answer = 1; // 주의하자. 선생님 다음으로 보이는 것은 1부터 시작한다!

        int max = arr[0];

        for (int i = 1; i < n; i++) {

            if (arr[i] > max) {
                answer++;
                max = arr[i];
            }
        }

        return answer;
    }

//    public static void main(String[] args) throws Exception {
//
//        Main9 t = new Main9();
//
//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();
//
//        int[] arr = new int[n];
//
//        for (int i = 0; i < n; i++) {
//
//            arr[i] = sc.nextInt();
//        }
//
//        System.out.print(t.solution(n, arr));
//    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String str = br.readLine();
//        System.out.println(str);
        br.close();

        String[] tmp = str.split(" ");

//        System.out.println(Arrays.toString(tmp));

//        System.out.println(tmp[0]);
//        System.out.println(tmp[7]);

//        System.out.println(n);


        int[] arr = new int[n];
//
        for (int i = 0; i < n; i++) {

            arr[i] = Integer.parseInt(tmp[i]);
//            System.out.println(arr[i] + " - " + tmp[i]);
//            System.out.println(strArr[i]);
        }
//
        System.out.print(t.solution(n, arr));
    }
}
