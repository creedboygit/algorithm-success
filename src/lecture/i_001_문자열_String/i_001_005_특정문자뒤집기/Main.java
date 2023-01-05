package lecture.i_001_문자열_String.i_001_005_특정문자뒤집기;

import java.io.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72709?category=questionDetail&tab=curriculum

//https://cote.inflearn.com/contest/10/problem/01-05

/*
i_001_005_특정문자뒤집기

설명

영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,

특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.


입력
첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.


출력
첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
*/

/*
입력
a#b!GE*T@S

출력
S#T!EG*b@a
*/

    public String solution(String str) {

        String answer;

        char[] c = str.toCharArray();

        int lt = 0;
        int rt = str.length() - 1; // 길이에서 -1 해주는거 까먹지 말자

        while(lt < rt) {

            if (!Character.isAlphabetic(c[lt])) lt++;
            else if (!Character.isAlphabetic(c[rt])) rt--;
            else {
                char tmp = c[lt];
                c[lt] = c[rt];
                c[rt] = tmp;

                lt++; // 까먹지 말자
                rt--; // 까먹지 말자
            }
        }

        answer = String.valueOf(c);

        return answer;
    }

    public static void main(String[] args) throws Exception {

        Main T = new Main();

        //Scanner sc = new Scanner(System.in);
        //String str = sc.next();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine(); // 까먹지 말자
        br.close(); // 까먹지 말자

        System.out.println(T.solution(str));
    }
}
