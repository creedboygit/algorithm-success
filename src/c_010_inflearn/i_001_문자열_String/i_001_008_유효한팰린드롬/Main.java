package c_010_inflearn.i_001_문자열_String.i_001_008_유효한팰린드롬;

import java.io.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72712?category=questionDetail&tab=curriculum

//https://cote.inflearn.com/contest/10/problem/01-08

/*
i_001_008_유효한팰린드롬

설명

앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.

문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.

단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.

알파벳 이외의 문자들의 무시합니다.


입력
첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.


출력
첫 번째 줄에 팰린드롬인지의 결과를 YES 또는 NO로 출력합니다.
*/

/*
입력
found7, time: study; Yduts; emit, 7Dnuof

출력
YES
*/

    /*
    StringBuilder 이용
     */
    public String solution1(String str) {

        String answer = "NO";

        str = str.toUpperCase().replaceAll("[^A-Z]", "");

//        System.out.println(str);

        String tmp = new StringBuilder(str).reverse().toString();

        if (str.equals(tmp)) answer = "YES";

        return answer;
    }


    /*
    lt, rt 이용
     */
    public String solution2(String str) {

//        String answer = "YES";
        boolean answer = true;

        str = str.toUpperCase().replaceAll("[^A-Z]", "");

//        System.out.println(str);

        char[] charArr = str.toCharArray();

        int lt = 0;
        int rt = str.length() - 1;

        while (lt < rt) {
            if (charArr[lt] != charArr[rt]) {
                answer = false;
                break;
            }

            lt++;
            rt--;
        }

//        for (int i = 0; i < str.length(); i++) {
//
//            if (charArr[lt] != charArr[rt]) answer = "NO";
//
//            lt++;
//            rt--;
//        }

//        return answer;
        return answer ? "YES" : "NO";
    }


    public static void main(String[] args) throws Exception {

        Main t = new Main();

//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        br.close(); // 까먹지 말자

//        System.out.println(t.solution1(str));
        System.out.println(t.solution2(str));
    }
}
