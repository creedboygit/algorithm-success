package c_010_인프런.i_002_Array_1_2차원배열.i_002_003_가위바위보;

import java.io.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72720?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/02-03

/*
i_002_003_가위바위보

설명

A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.

가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.

예를 들어 N=5이면

Image1.jpg

두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.


입력
첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.

두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.

세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.


출력
각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.
*/

/*
입력
5
2 3 3 1 3
1 1 2 2 3

출력
A
B
A
B
D

가위 : 1, 바위 : 2, 보 : 3
*/

    public char[] solution(int n, int[] a, int[] b) {
        char[] answer = new char[n];

        for (int i = 0; i < n; i++) {

            if (a[i] == b[i]) {
                answer[i] = 'D';
            } else if (a[i] == 1 && b[i] == 3) {
                answer[i] = 'A';
            } else if (a[i] == 2 && b[i] == 1) {
                answer[i] = 'A';
            } else if (a[i] == 3 && b[i] == 2) {
                answer[i] = 'A';
            } else {
                answer[i] = 'B';
            }
        }

        return answer;
    }

    public String solution2(int n, int[] a, int[] b) {
        String answer = "";

        for (int i = 0; i < n; i++) {

            if (a[i] == b[i]) {
                answer += "D";
            } else if (a[i] == 1 && b[i] == 3) {
                answer += "A";
            } else if (a[i] == 2 && b[i] == 1) {
                answer += "A";
            } else if (a[i] == 3 && b[i] == 2) {
                answer += "A";
            } else {
                answer += "B";
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
//        int[] a = new int[n];
//        int[] b = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            a[i] = sc.nextInt();
//        }
//
//        for (int i = 0; i < n; i++) {
//            b[i] = sc.nextInt();
//        }
//
////        for (char x : t.solution(n, a, b)) System.out.println(x);
//
//        for (char x : t.solution2(n, a, b).toCharArray()) {
//            System.out.println(x);
//        }
//    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        int[] a = new int[n];
        int[] b = new int[n];

        String aLine = br.readLine();
        String bLine = br.readLine();

        String[] aTmp = aLine.split(" ");
        String[] bTmp = bLine.split(" ");

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(aTmp[i]);
        }

        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(bTmp[i]);
        }

//        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(b));

        for (char x : t.solution2(n, a, b).toCharArray()) {
            System.out.println(x);
        }
    }
}
