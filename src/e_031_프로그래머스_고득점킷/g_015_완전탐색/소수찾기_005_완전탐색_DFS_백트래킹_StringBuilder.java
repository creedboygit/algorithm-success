package e_031_프로그래머스_고득점킷.g_015_완전탐색;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42839

"17"	3
"011"	2

17
정답 : 3

011
정답 : 2

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

//Solution
public class 소수찾기_005_완전탐색_DFS_백트래킹_StringBuilder {

    static boolean[] visited;
    static HashSet<Integer> set = new HashSet<>();

    static StringBuilder sb = new StringBuilder();

    public static int solution(String numbers) {

        int answer = 0;

        visited = new boolean[numbers.length()];

        dfs(numbers,  0);

        for (Integer num : set) {
            if (isPrime(num)) answer++;
        }

        return answer;
    }

    // 백트래킹
    static void dfs(String numbers, int len) {

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            sb.append(numbers.charAt(i));

            set.add(Integer.parseInt(sb.toString()));

            dfs(numbers, len + 1);

            visited[i] = false; // 백트래킹
            sb.deleteCharAt(sb.length() - 1); // 백트래킹
        }
    }

    public static boolean isPrime(int numbers) {

        // 1. 0과 1은 소수가 아니다.
        if (numbers == 0 || numbers == 1) {
            return false;
        }

        // 2. 에라토스테네스의 체의 limit 숫자를 계산한다.
        int limit = (int) Math.sqrt(numbers);

        // 3. 에라토스테네스의 체에 따라 limit 까지 배수 여부를 확인한다.
        for (int i = 2; i <= limit; i++) {
            if (numbers % i == 0)
                return false;
        }

//        System.out.println(numbers);

        return true;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String number = br.readLine();

        System.out.println(solution(number));
    }
}
