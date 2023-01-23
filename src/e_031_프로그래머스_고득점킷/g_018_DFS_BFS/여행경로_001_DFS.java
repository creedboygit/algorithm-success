package e_031_프로그래머스_고득점킷.g_018_DFS_BFS;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/43164

[["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]
정답 : ["ICN", "JFK", "HND", "IAD"]

문제
3
ICN JFK
HND IAD
JFK HND

정답 : ["ICN", "JFK", "HND", "IAD"]


[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]
정답 : ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

import static e_031_프로그래머스_고득점킷.g_018_DFS_BFS.타겟넘버_DFS.dfs;

//Solution
public class 여행경로_001_DFS {

    static ArrayList<String> answers;
    static boolean visited[];

    public static String[] solution(String[][] tickets) {

        answers = new ArrayList<>();

        visited = new boolean[tickets.length];

        int count = 0; // 몇 개의 공항을 들렀는지 알려주는 카운트
        dfs(count, "ICN", "ICN", tickets);

        Collections.sort(answers); // 답들 중 가장 알파벳 순이 빠른 배열들로 정렬

        String[] answer = answers.get(0).split(" ");
        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] tickets = new String[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tickets[i][0] = st.nextToken();
            tickets[i][1] = st.nextToken();
        }

//        System.out.println(Arrays.deepToString(arr));

        System.out.println(solution(tickets));
    }
}
