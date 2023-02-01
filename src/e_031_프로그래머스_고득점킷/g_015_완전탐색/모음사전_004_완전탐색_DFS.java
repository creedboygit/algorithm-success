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
import java.sql.Array;
import java.util.ArrayList;

//Solution
public class 모음사전_004_완전탐색_DFS {

    static ArrayList<String> dictionary = new ArrayList<>();
//    static String letters = "AEIOU";
    static String[] letters = {"A", "E", "I", "O", "U"};
    static boolean isStop = false;

    public static int solution(String word) {

        dfs("", 0, word);

        return dictionary.indexOf(word); // ""가 한번 들어가기 때문에 +1 안해도 된다.
    }

    private static void dfs(String str, int depth, String target) {

        if (depth > 5) return;

        dictionary.add(str);

        if (str.equals(target)) { // word가 완성되면 그만 돌기
            isStop = true;
            return;
        }

        for (int i = 0; i < 5; i++) {

            if (isStop) return;

//            dfs(str + letters.charAt(i), depth + 1);
            dfs(str + letters[i], depth + 1, target);
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        System.out.println(solution(word));
    }
}