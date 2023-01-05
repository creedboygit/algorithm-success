package c_010_inflearn.i_001_문자열_String.i_001_010_가장짧은문자거리;

import java.io.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72714?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/01-10

/*
i_001_010_가장짧은문자거리

설명

한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.


입력
첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.

문자열의 길이는 100을 넘지 않는다.


출력
첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
*/

/*
입력
teachermode e

출력
1 0 1 2 1 0 1 2 2 1 0
*/

    public int[] solution(String str, char c) {

        int[] answer = new int[str.length()];

        int p = 1000; // 일단 넉넉하게 큰 값으로 초기화

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                p = 0;
                answer[i] = p;
            } else {
                p++;
                answer[i] = p;
            }
        }

//        System.out.println(answer);

        p = 1000; // 초기화 까먹지 말자

        for (int i = str.length() - 1; i >= 0; i--) { // 길이 -1 해주는거 까먹지 말자
            if (str.charAt(i) == c) {
                p = 0;
//                answer[i] = p; // 굳이 해줄 필요 없다. 위에서 0이므로
            } else {
                p++;
                answer[i] = Math.min(p, answer[i]); // 최소값 구하기
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();
//        char c = sc.next().charAt(0);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

//        String str = st.nextToken();
//        char c = st.nextToken().charAt(0);

        String s = br.readLine();
        br.close(); // 까먹지 말자

        String[] arr = s.split(" ");

        String str = arr[0].trim();
        char c = arr[1].charAt(0);

//        System.out.println(str);
//        System.out.println(c);

//        String str = br.readLine();

        String result = "";

        StringBuilder sb = new StringBuilder();

        for (int x : t.solution(str, c)) {
//            result += x + " ";
//            result = sb.append(x + " ").toString();
            result = sb.append(x).append(" ").toString();
        }

        result = result.trim();

        System.out.print(result);
    }
}
