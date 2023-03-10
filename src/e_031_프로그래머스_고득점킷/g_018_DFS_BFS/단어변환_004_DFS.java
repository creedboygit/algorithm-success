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
import java.util.StringTokenizer;

//Solution
public class 단어변환_004_DFS {

    static boolean visited[];
    static int answer = 0;

    public static int solution(String begin, String target, String[] words) {

        answer = 51; // 문제 조건에서 50개까지라고 했으므로 최소 51개로 잡음
        visited = new boolean[words.length]; // 방문 배열 초기화
        dfs(begin, target, words, 0); // dfs 초기화

        if (answer == 51) answer = 0;

        return answer;
    }

    private static void dfs(String now, String target, String[] words, int depth) {

        // 탈출 조건
        if (now.equals(target)) {
            answer = Math.min(answer, depth);
        }

        if (depth > words.length) return;

        // 수행 조건
        for (int i = 0; i < words.length; i++) {

            int diff = 0;

            for (int j = 0; j < now.length(); j++) {
                if (now.charAt(j) != words[i].charAt(j))
                    diff++;
            }

            // 방문하지 않았고, check 시 한 글자만 차이날 때
            if (diff == 1 && !visited[i]) {

                visited[i] = true;
                dfs(words[i], target, words, depth + 1); // cnt++ 아니다 -> cnt + 1 로 해줘야 한다.
                visited[i] = false; // 꼭 다시 돌아왔을 때 다시 체크하기 위해 방문 배열을 false로 초기화 해줘야 한다. 다시 탐색을 위해서 방문 처리 초기화
            }
        }
    }

    // 1글자만 같은 경우 true 반환
    public static boolean check(String now, String next) {
        int count = 0;
        for (int i = 0; i < now.length(); i++) {
            if (now.charAt(i) != next.charAt(i)) {
                count++;
            }
        }

        return count == 1 ? true : false;
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
