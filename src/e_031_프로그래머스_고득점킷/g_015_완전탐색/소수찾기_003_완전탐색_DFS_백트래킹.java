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
import java.util.Iterator;

//Solution
public class 소수찾기_003_완전탐색_DFS_백트래킹 {

//    static HashSet<Integer> numberSet = new HashSet<>(); // 중복값 제거 위한 set

    static ArrayList<Integer> arr = new ArrayList<>();
    static boolean[] visited = new boolean[7];

    public static int solution(String numbers) {

        int answer = 0;
        for (int i = 0; i < numbers.length(); i++) {
            dfs(numbers, "", i + 1);
        }

        for (int i = 0; i < arr.size(); i++) {
            if (isPrime(arr.get(i))) answer++;
        }

        return answer;
    }

    // 백트래킹
    static void dfs(String str, String temp, int len) {
        if (temp.length() == len) {
            int num = Integer.parseInt(temp); // 001, 01, 1 은 모두 같으므로
            if (!arr.contains(num)) {
                arr.add(num);
            }
        }

        for (int i = 0; i < str.length(); i++) {
            if (visited[i]) continue;

            visited[i] = true;
            temp += str.charAt(i);
            dfs(str, temp, len);
            visited[i] = false; // 백트래킹을 위하여
            temp = temp.substring(0, temp.length() - 1); // 백트래킹을 위하여 맨 뒤에 한 개 원복
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
