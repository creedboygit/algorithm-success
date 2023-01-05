package lecture.i_001_문자열_String.i_001_001_문자찾기;

import java.io.*;

class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72705?category=questionDetail&tab=curriculum

//https://cote.inflearn.com/contest/10/problem/01-01

/*
1. 문자 찾기

설명

한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.

대소문자를 구분하지 않습니다.문자열의 길이는 100을 넘지 않습니다.


입력
첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어진다.

문자열은 영어 알파벳으로만 구성되어 있습니다.


출력
첫 줄에 해당 문자의 개수를 출력한다.
*/

/*
입력
Computercooler
c

출력
2
*/

    public int solution(String str, char t) {
        int answer = 0;

        str = str.toUpperCase();
        t = Character.toUpperCase(t);

//        System.out.println(str + " " + t);

//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == t) answer++;
//        }

        for (char x : str.toCharArray()) {
            if (x == t) answer++;
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine();
        String input2 = br.readLine();
        br.close();

        char t = input2.charAt(0);

//        Scanner sc = new Scanner(System.in);
//        String input1 = sc.next();
//        char t = sc.next().charAt(0);


//        System.out.print("answer : " + T.solution(input1, t));
        System.out.print(T.solution(input1, t));
    }
}