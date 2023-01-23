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
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//Solution
public class 여행경로_002_DFS_미리정렬해놓기 {

    static ArrayList<String> path = new ArrayList<>();
    static PriorityQueue<String> answer = new PriorityQueue<>();
    static boolean visited[];

    public static String[] solution(String[][] tickets) {

        visited = new boolean[tickets.length];

        dfs("ICN", 0, tickets);

//        return answer.poll().split(" ");
        return answer.poll().split(",");
    }

    private static void dfs(String cur, int depth, String[][] tickets) {

        path.add(cur);

        if (depth == tickets.length) {
//            answer.add(String.join(" ", path));
            answer.add(String.join(",", path));
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(cur)) { // i번째 티켓을 아직 사용하지 않았고, 출발지가 cur과 같은 티켓이 있다면
                visited[i] = true;
                dfs(tickets[i][1], depth + 1, tickets);
                visited[i] = false;
                path.remove(path.size() - 1);
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
