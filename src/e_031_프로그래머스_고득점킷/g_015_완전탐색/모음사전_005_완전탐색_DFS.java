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
import java.util.ArrayList;

//Solution
public class 모음사전_005_완전탐색_DFS {

    static String[] letters = {"A", "E", "I", "O", "U"};
    static int answer = 0;
    static int count = 0;

    public static int solution(String word) {

        dfs("", word);

        return answer;
    }

    private static void dfs(String cur, String word) {

        if (cur.equals(word)) {
            answer = count;
            return;
        }

        if (cur.length() >= 5)
            return;

        for (int i = 0; i < 5; i++) {
            count++;
            dfs(cur + letters[i], word);
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        System.out.println(solution(word));
    }
}