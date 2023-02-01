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
import java.util.Collections;

//Solution
public class 모음사전_002_완전탐색_DFS {

    static ArrayList<String> list;
//    static char[] chars = {'A', 'E', 'I', 'O', 'U'};
    static String[] chars = {"A", "E", "I", "O", "U"}; // char 보다 String이 훨훨씬 빠르다.


    public static int solution(String word) {

        int answer = 0;

//        chars = new char[] {'A', 'E', 'I', 'O', 'U'};
        list = new ArrayList<>();

        dfs("", 0);

//        System.out.println(list);

        answer = list.indexOf(word);

        return answer;
    }

    public static void dfs(String str, int depth) {

        list.add(str); // 이게 먼저 와야 한다.

        if (depth >= 5) return;

        for (int i = 0; i < chars.length; i++) {

            dfs(str + chars[i], depth + 1);
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        System.out.println(solution(word));
    }
}