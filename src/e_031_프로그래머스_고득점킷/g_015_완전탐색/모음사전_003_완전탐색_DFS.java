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
public class 모음사전_003_완전탐색_DFS {

//    static char[] chars = {'A', 'E', 'I', 'O', 'U'};
    static String[] chars = {"A", "E", "I", "O", "U"};
    static int count = 0;
    static boolean isStop = false;


    public static int solution(String word) {

        dfs(0, "", word);

        return count;
    }

    public static void dfs(int depth, String next, String target) {

        if (depth > 5) return;

        if (next.equals(target)) {
            isStop = true;
            return;
        }

        for (int i = 0; i < 5; i++) {

            if (isStop) return;

            if (depth < 5) count++;
            dfs(depth + 1, next + chars[i], target);
        }
    }


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        System.out.println(solution(word));
    }
}