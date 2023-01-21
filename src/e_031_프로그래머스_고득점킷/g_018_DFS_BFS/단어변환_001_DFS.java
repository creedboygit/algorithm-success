package e_031_프로그래머스_고득점킷.g_018_DFS_BFS;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/43163

begin	target	words	return
"hit"	"cog"	["hot", "dot", "dog", "lot", "log", "cog"]	4
"hit"	"cog"	["hot", "dot", "dog", "lot", "log"]	0

hit cog
6
hot dot dog lot log cog
답 : 4

최소 경로를 구하는 문제이므로 시간복잡도 때문에 BFS를 이용해야 한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

//Solution
public class 단어변환_001_DFS {

    static boolean visited[];
    static int answer = 0;

    public static int solution(String begin, String target, String[] words) {

        visited = new boolean[words.length];

        dfs(begin, target, words, 0);

        return answer;
    }

    private static void dfs(String begin, String target, String[] words, int cnt) {

        // 탈출 조건
        if (begin.equals(target)) {
            answer = cnt;
            return;
        }

        // 수행 조건
        for (int i = 0; i < words.length; i++) {
            if (visited[i]) {
                continue;
            }

            int k = 0; // 같은 스펠링 몇 개인지 세기
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    k++;
                }
            }

            if (k == begin.length() - 1) { // 한 글자 빼고 모두 같은 경우
                visited[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visited[i] = false; // 꼭 다시 돌아왔을 때 다시 체크하기 위해 방문 배열을 false로 초기화 해줘야 한다. 다시 탐색을 위해서 방문 처리 초기화
            }
        }


    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String begin = st.nextToken();
        String target = st.nextToken();

        int wordsLength = Integer.parseInt(br.readLine());

        String[] words = new String[wordsLength];
        StringTokenizer wst = new StringTokenizer(br.readLine());

        for (int i = 0; i < wordsLength; i++) {
            words[i] = wst.nextToken();
        }

        System.out.println(solution(begin, target, words));

//        System.out.println(begin);
//        System.out.println(target);
//        System.out.println(Arrays.toString(words));
    }
}
