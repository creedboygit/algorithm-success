package lecture.i_001_문자열_String.i_001_002_대소문자변환;

import java.io.*;

public class Main {


//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72706?category=questionDetail&tab=curriculum

//https://cote.inflearn.com/contest/10/problem/01-02

/*
i_001_002_대소문자변환

설명

대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.


입력
첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.

문자열은 영어 알파벳으로만 구성되어 있습니다.


출력
첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
*/

/*
입력
sTuDy

출력
sTUdy
*/

    public String solution(String str) {

        String answer = "";

//        for (int i = 0; i < str.length(); i++) {
//
//            char c = str.charAt(i);
//            if (Character.isLowerCase(c)) answer += Character.toUpperCase(c);
//            else answer += Character.toLowerCase(c);
//        }

//        for (char x : str.toCharArray()) {
//            if (Character.isLowerCase(x)) answer += Character.toUpperCase(x);
//            else answer += Character.toLowerCase(x);
//        }

        StringBuilder sb = new StringBuilder();

        for (char x : str.toCharArray()) {
//            if (x >= 65 && x <= 90) System.out.println(x);
//            if (x >= 65 && x <= 90) answer += (char)(x + 32);
            if (x >= 65 && x <= 90) answer = sb.append((char)(x + 32)).toString();
//            else answer += (char)(x - 32);
            else answer = sb.append((char)(x - 32)).toString();
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close(); // 까먹지 말자

//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();

//        char t = br.readLine().charAt(0);

        System.out.print(T.solution(str));
    }
}
