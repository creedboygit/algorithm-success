package e_031_프로그래머스_고득점킷.g_016_탐욕법그리디;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42883

1924 2
정답 : 94

1231234 3
정답 : 3234

4177252841 4
정답 : 775841

23563850135 7
정답 : 8535
 */

// number.length() - k 자리수만큼 구해야 한다.
// 자리수가 n이라고 치면, 뒤에서 n-1개 만큼 빼고 앞에서 최댓값을 구한다.
// 답에 추가하고, 그 index 기준으로 남은 자리수만큼 빼놓고 최대값을 구한다.
// + 시간때문에 StringBuilder사용하자

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Solution
public class 큰수만들기_006_그리디_이중포문_찍어보기 {

    public static String solution(String number, int k) {

        StringBuilder answer = new StringBuilder();

        int idx = 0;
        int max = 0;

        for (int i = 0; i < number.length() - k; i++) {

            max = 0;

            System.out.println("i : " + i);

            for (int j = idx; j <= i + k; j++) {

                System.out.println("j : " + j);

                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';

                    System.out.println("max1 : " + max);

                    idx = j + 1;

                    System.out.println("idx2 : " + idx);
                    System.out.println();
                }

                System.out.println("max2 : " + max);
            }

            System.out.println();
            System.out.println();

            answer.append(max);
        }

        return answer.toString();
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String number = st.nextToken();
        int k = Integer.parseInt(st.nextToken());

        System.out.println(solution(number, k));
    }
}
