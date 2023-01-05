package c_010_inflearn.i_001_문자열_String.i_001_006_중복문자제거;

import java.io.*;
import java.util.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72710?category=questionDetail&tab=curriculum

//https://cote.inflearn.com/contest/10/problem/01-06


/*
i_001_006_중복문자제거

설명

소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.

중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.


입력
첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.


출력
첫 줄에 중복문자가 제거된 문자열을 출력합니다.
*/

/*
입력
ksekkset

출력
kset
*/

    /*
    indexOf 사용
     */
//    public String solution(String str) {
//        String answer = "";
//
//        for (int i = 0; i < str.length(); i++) {
////            System.out.println(str.charAt(i) + " " + i + " " + str.indexOf(str.charAt(i)));
//
//            if (str.indexOf(str.charAt(i)) == i) {
//                answer += str.charAt(i);
//            }
//        }
//
//        return answer;
//    }

    /*
    HashMap 사용
     */
//    public String solution(String str) {
//
//        String answer = "";
//
//        char[] c = str.toCharArray();
//        HashMap<Character, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < str.length(); i++) {
//            if (!map.containsKey(c[i])) {
//                answer += c[i];
//            }
//
//            map.put(c[i], 1);
//        }
//
//        return answer;
//    }

    /*
    String형.contains(String형 문자) 사용
     */
//    public String solution(String str) {
//
//        String answer = "";
//
//        for (char c : str.toCharArray()) {
//
//            if (!answer.contains(String.valueOf(c))) {
//                answer += c;
//            }
//        }
//
//        return answer;
//    }


    /*
    indexOf == -1 사용
     */
//    public String solution(String str) {
//
//        String answer = "";
//
//        char[] charArr = str.toCharArray();
//        for (char c : charArr) {
//            if (answer.indexOf(c) == -1) {
//                answer += c;
//            }
//        }
//
//        return answer;
//    }

    /*
    List 사용
     */
    public String solution(String str) {

        String answer = "";

        ArrayList<Character> list = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for (char a : str.toCharArray()) {
            if (!list.contains(a)) {
                list.add(a);
//                answer += a;
                answer = sb.append(a).toString();

            }
        }

        return answer;
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
