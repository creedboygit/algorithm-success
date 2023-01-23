package c_010_인프런.i_001_문자열_String.i_001_007_회문문자열;

import java.io.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72711?category=questionDetail&tab=curriculum

//https://cote.inflearn.com/contest/10/problem/01-07

/*
i_001_007_회문문자열 펠린드롬

설명

앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.

문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.

단 회문을 검사할 때 대소문자를 구분하지 않습니다.


입력
첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.


출력
첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.
*/

/*
입력
gooG

출력
YES
*/

    /*
    나누기 2를 해서 비교
     */
//    public String solution(String str) {
//
//        String answer = "YES";
//
//        str = str.toUpperCase();
//        int len = str.length();
//        for (int i = 0; i < len / 2; i++) {
//            if (str.charAt(i) != str.charAt(len - i - 1)) answer = "NO";
//        }
//
//        return answer;
//    }

    /*
    StringBuilder로 비교
     */
//    public String solution(String str) {
//        String answer = "YES";
//
//        String tmp = new StringBuilder(str).reverse().toString(); // toString() 까먹지 말자
//
//        if (!tmp.equalsIgnoreCase(str)) answer = "NO";
//
//        return answer;
//    }

    /*
    왼쪽 문자열, 오른쪽 문자열 비교
     */
    public String solution(String str) {
        boolean answer = true;

        str = str.toLowerCase();

        char[] charArr = str.toCharArray();
        int lt = 0;
        int rt = str.length() - 1; // -1 해주는거 까먹지 말자

        while (lt < rt) { // 까먹지 말자
            if (charArr[lt] != charArr[rt]) {
                answer = false;
                break;

            }

            lt++; // 까먹지 말자
            rt--; // 까먹지 말자
        }


        return answer ? "YES" : "NO";
    }


    public static void main(String[] args) throws Exception {
        Main t = new Main();

//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        br.close(); // 까먹지 말자

        System.out.println(t.solution(str));
    }
}
