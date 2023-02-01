package e_031_프로그래머스_고득점킷.g_015_완전탐색;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/84512

"AAAAE"	6
"AAAE"	10
"I"	1563
"EIO"	1189


AAAAE

정답 : 6

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Solution
public class 모음사전_006_완전탐색_산수 {

    public static int solution(String word) {

        int answer = 0;
        int diff = 781;

//        char alphabet[] = {'A', 'E', 'I', 'O', 'U'};
        String[] alphabet = {"A", "E", "I", "O", "U"};

        for (int i = 0; i < word.length(); i++) {

            for (int j = 0; j < 5; j++) {

//                if (alphabet[j] == word.charAt(i)) {
                if (alphabet[j].equals(String.valueOf(word.charAt(i)))) {

                    answer += 1 + j * diff;
                }
            }

            diff = (diff - 1) / 5;
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        System.out.println(solution(word));
    }
}