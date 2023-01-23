package c_010_인프런.i_001_문자열_String.i_001_011_문자열압축;

import java.io.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72715?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/01-11

/*
i_001_011_문자열압축

설명

알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는

문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.

단 반복횟수가 1인 경우 생략합니다.


입력
첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.


출력
첫 줄에 압축된 문자열을 출력한다.
*/

/*
입력1
KKHSSSSSSSE

출력1
K2HS7E

입력2
KSTTTSEEKFKKKDJJGG

출력2
KST3SE2KFK3DJ2G2
*/

    public String solution1(String str) {
        String answer = "";

        str += " "; //  맨 뒤에 비교용 공백 넣기

        int cnt = 1;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length() - 1; i++) { // 맨 뒤에 비교용 공백 넣어줬으므로 길이 -1
            if (str.charAt(i) == str.charAt(i + 1)) cnt++;
            else {
//                answer += str.charAt(i);
                answer = String.valueOf(sb.append(str.charAt(i)));
//                if (cnt > 1) answer += cnt;
//                if (cnt > 1) answer += String.valueOf(cnt);
//                if (cnt > 1) answer += Integer.toString(cnt);
                if (cnt > 1) answer = String.valueOf(sb.append(Integer.toString(cnt)));
                cnt = 1; // 초기화 까먹지 말기
            }
        }

        return answer;
    }

    public String solution2(String str) {
        String answer = "";

        str += " ";
        char tmp = ' ';
        int cnt = 1;

        for (int i = 0; i < str.length(); i++) {

            System.out.println(i + " " + str.charAt(i));

            if (str.charAt(i) == tmp) {
                cnt++;
//                System.out.println("111" + answer);
            } else {
                answer += tmp + String.valueOf(cnt);

//                System.out.println("222" + answer);

                cnt = 1; // 초기화 까먹지 말기
            }

            tmp = str.charAt(i);
        }

        answer = answer.replaceAll("1", "").trim();

        return answer;
    }

    public static void main(String[] args) throws Exception {
        Main t = new Main();

//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        br.close();

//        System.out.println(t.solution1(str));
        System.out.println(t.solution2(str));
    }
}
