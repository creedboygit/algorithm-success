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
import java.util.Dictionary;

//Solution
public class 모음사전_006_완전탐색_DFS {

    static String[] letters = {"A", "E", "I", "O", "U"};
    static int cnt = 0;
    static int answer = 0;

    public static int solution(String word) {

        dfs("", word);

        return answer;
    }

    private static void dfs(String cur, String target) {

        if (cur.length() == 5 || cur.equals(target)) {
            if (cur.equals(target))
                answer = cnt;

            return;
        }

        for (int i = 0; i < 5; i++) {
            cnt++;
            dfs(cur + letters[i], target);
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        System.out.println(solution(word));
    }
}