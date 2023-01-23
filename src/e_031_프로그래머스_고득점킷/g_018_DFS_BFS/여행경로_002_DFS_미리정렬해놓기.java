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
import java.util.Arrays;
import java.util.StringTokenizer;

//Solution
public class 여행경로_002_DFS_미리정렬해놓기 {


    static String answer;
    static boolean visited[];

    public static String[] solution(String[][] tickets) {

        answer = "";

        visited = new boolean[tickets.length];

        Arrays.sort(tickets, (o1, o2) -> o1[1].compareTo(o2[1]));

        dfs(0, "ICN", "ICN", tickets);

        return answer.split(" ");
    }

    private static void dfs(int count, String cur, String result, String[][] tickets) {

        if (count == tickets.length) { // 모든 공항을 돌았다면
            if (!answer.equals("")) {
                return;
            }

            answer = result;
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && cur.equals(tickets[i][0])) { // present와 같고 들리지 않은 공항을 찾고
                visited[i] = true; // 해당 공항을 들린 것으로 방문 체크
                dfs(count + 1, tickets[i][1], result + " " + tickets[i][1], tickets); // 카운트 + 1 도착 공항을 present로 넣어주고 answer에 도착 공항을 추가한다.
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
