package lecture.i_001_문자열_String.i_001_003_문장속단어;

import java.io.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72707?category=questionDetail&tab=curriculum

//https://cote.inflearn.com/contest/10/problem/01-03

/*
i_001_003_문장속단어

설명

한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.

문장속의 각 단어는 공백으로 구분됩니다.


입력
첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.


출력
첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한

단어를 답으로 합니다.
*/

/*
입력
it isssss timesss to studys123123

출력
study
*/

    public String solution(String str) {

        String answer = "";

//        int m = Integer.MIN_VALUE;
//        int pos;
        int m = Integer.MIN_VALUE, pos;


//        String[] s = str.split(" ");
//
//        for (String x : s) {
//
//            int len = x.length();
//
//            if (len > m) {
//                m = len;
//                answer = x;
//            }
//        }

        while ((pos = str.indexOf(" ")) != -1) {

            String s = str.substring(0, pos);
            int len = s.length();

            if (len > m) {
                m = len;
                answer = s;
            }

            str = str.substring(pos + 1);
        }

        if (str.length() > m) answer = str;

        return answer;
    }

    public static void main(String[] args) throws Exception {

        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close(); // 까먹지 말자

//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();

//        System.out.print(str);

        System.out.print(T.solution(str));
    }
}
