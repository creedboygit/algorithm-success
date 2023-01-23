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
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

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

        String[] answer = answers.get(0).split(" "); // 답들 중 가장 알파벳 순이 빠른 것에서 빈 칸으로 split 해서 배열에 담음
        return answer;
    }

    private static void dfs(int count, String present, String answer, String[][] tickets) {

        if (count == tickets.length) { // 모든 공항을 돌았다면
            answers.add(answer); // answer에 추가
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(present)) { // present와 같고 들리지 않은 공항을 찾고
                visited[i] = true; // 해당 공항을 들린 것으로 방문 체크
                dfs(count + 1, tickets[i][1], answer + " " + tickets[i][1], tickets); // 카운트 + 1 도착 공항을 present로 넣어주고 answer에 도착 공항을 추가한다.
                visited[i] = false;
            }
        }
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

        System.out.println(Arrays.toString(solution(tickets)));
    }
}
