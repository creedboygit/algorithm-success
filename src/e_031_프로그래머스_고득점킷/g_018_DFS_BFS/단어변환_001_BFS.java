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
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//Solution
public class 단어변환_001_BFS {

    static boolean visited[];
    static int answer = 0;

    public static int solution(String begin, String target, String[] words) {

        visited = new boolean[words.length]; // 방문 배열 초기화
        return bfs(begin, target, words);
    }

    private static int bfs(String begin, String target, String[] words) {

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(begin, 0));

        while (!q.isEmpty()) {

            Node node = q.poll();
            if (node.word.equals(target)) return node.count;

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && check(node.word, words[i])) {
                    visited[i] = true;
                    q.offer(new Node(words[i], node.count + 1));
                }
            }
        }

        return 0;
    }

    // 1글자만 같은 경우 true 반환
    public static boolean check(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
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

    private static class Node {

        String word;
        int count;

        public Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}
