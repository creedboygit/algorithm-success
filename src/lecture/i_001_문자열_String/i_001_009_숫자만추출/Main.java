package lecture.i_001_문자열_String.i_001_009_숫자만추출;

import java.io.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72713?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/01-09

/*
i_001_009_숫자만추출

설명

문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.

만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.

추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.


입력
첫 줄에 숫자가 섞인 문자열이 주어집니다. 문자열의 길이는 100을 넘지 않습니다.


출력
첫 줄에 자연수를 출력합니다.
*/

/*
입력
g0en2T0s8eSoft

출력
208
*/

    /*
    아스키코드 이용 ('0' : 48 ~ '9' : 57)
     */
    public int solution1(String str) {
        int answer = 0;

        for (char c : str.toCharArray()) {
            if (c >= 48 && c <= 57) {
                answer = (answer * 10) + (c - 48);
            }
        }

        return answer;
    }

    /*
    isDigit(c) 이용
     */
    public int solution2(String str) {
        String answer = ""; // String형 까먹지 말자

        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
//            if (Character.isDigit(c)) answer += c;
            if (Character.isDigit(c)) answer = sb.append(c).toString(); // toString() 까먹지 말자, += 이 아니고 answer = 이다
        }

//        System.out.println(answer);

//        return 0;
        return Integer.parseInt(answer); // Integer.parseInt(스트링형) 까먹지 말자
    }

    /*
    정규식으로 숫자 외에 다른 것들을 없애고 시작
     */
    public int solution3(String str) {

        return Integer.parseInt(str.replaceAll("[^0-9]", "")); // 정규식 ^ 는 부정
    }

    /*
    정규식으로 문자를 제외하고 시작
     */
    public int solution4(String str) {

        return Integer.parseInt(str.replaceAll("[a-z]|[A-Z]", "")); // 정규식 중간에 | 를 까먹지 말자
    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        br.close(); // 까먹지 말자

//        System.out.println(t.solution1(str));
//        System.out.println(t.solution2(str));
//        System.out.println(t.solution3(str));
        System.out.println(t.solution4(str));
    }
}
