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
public class 모음사전_001_완전탐색_DFS_002보다훨빠르다 {

    static ArrayList<String> list;
    static String[] arr;

    public static int solution(String word) {

        int answer = 0;

        list = new ArrayList<>();
        arr = new String[] {"A", "E", "I", "O", "U"};

        // 완전 탐색 메서드 호출
        dfs(word, "", 0);

        // 선형 탐색
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }

//        System.out.println(list);

        return answer;
    }

    public static void dfs(String word, String str, int depth) {

        list.add(str);
//        System.out.println(str);

        if (depth == 5)
            return;

        for (int i = 0; i < arr.length; i++) {

//            System.out.println(str + arr[i]);
            dfs(word, str + arr[i], depth + 1);
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        System.out.println(solution(word));
    }
}