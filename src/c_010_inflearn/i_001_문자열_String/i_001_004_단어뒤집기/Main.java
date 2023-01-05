package c_010_inflearn.i_001_문자열_String.i_001_004_단어뒤집기;

import java.io.*;
import java.util.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72708?category=questionDetail&tab=curriculum

//https://cote.inflearn.com/contest/10/problem/01-04

/*
i_001_004_단어뒤집기

설명

N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.


입력
첫 줄에 자연수 N(3<=N<=20)이 주어집니다.

두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.


출력
N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.
*/

/*
입력
3
good
Time
Big

출력
doog
emiT
giB
*/

//    public String solution(String str) {
//        String answer = "";
//
//        return answer;
//    }

//    public ArrayList<String> solution(int n, String[] str) {
    public ArrayList<String> solution(String[] str) {
        ArrayList<String> answer = new ArrayList<>();

//        for (String x : str) {
//            String tmp = new StringBuilder(x).reverse().toString();
//            answer.add(tmp);
//        }

        for (String x : str) {
            char[] s = x.toCharArray();
            int lt = 0;
            int rt = s.length - 1;

            while (lt < rt) {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;

                lt++;
                rt--;
            }

            String tmp = String.valueOf(s);
            answer.add(tmp);
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        Main T = new Main();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();

//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();
//        String str = sc.next();

//        System.out.print(T.solution(str));


//        Scanner sc = new Scanner(System.in);

//        int n = sc.nextInt();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] str = new String[n];

        for (int i = 0; i < n; i++) {
//            str[i] = sc.next();
            str[i] = br.readLine();
        }

        br.close(); // 까먹지 말자

//        for (String x : T.solution(n, str)) {
        for (String x : T.solution(str)) {
            System.out.println(x);
        }
    }
}
