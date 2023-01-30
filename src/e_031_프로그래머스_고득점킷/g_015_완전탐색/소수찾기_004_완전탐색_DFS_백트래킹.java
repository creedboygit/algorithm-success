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
import java.util.ArrayList;
import java.util.HashSet;

//Solution
public class 소수찾기_004_완전탐색_DFS_백트래킹 {

    static boolean[] visited;
    static HashSet<Integer> set = new HashSet<>();

    public static int solution(String numbers) {

        visited = new boolean[numbers.length()];

        dfs(numbers, "", 0);

        return set.size();
    }

    // 백트래킹
    static void dfs(String numbers, String temp, int len) {

        if (len == numbers.length())
            return;

        for (int i = 0; i < numbers.length(); i++) {

            if (visited[i]) continue;

            visited[i] = true;

            String number1 = temp + numbers.charAt(i);
            int number2 = Integer.parseInt(number1);

            if (isPrime(number2))
                set.add(number2);

            dfs(numbers, number1, len + 1);

            visited[i] = false; // 백트래킹을 위하여
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
