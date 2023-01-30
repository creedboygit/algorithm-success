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
public class 소수찾기_002_완전탐색_DFS_백트래킹 {

    static HashSet<Integer> set = new HashSet<>(); // 중복값 제거 위한 set
    static char[] arr; // 숫자가 적힌 종이조각
    static boolean[] visited; // 방문 여부

    public static int solution(String numbers) {

        int answer = 0;
        arr = new char[numbers.length()];
        visited = new boolean[numbers.length()];

        for (int i = 0; i < numbers.length(); i++) {
            arr[i] = numbers.charAt(i);
        }

        dfs("", 0);

        answer = set.size();

        return answer;
    }


    // dfs 재귀로 구현, 가능한 숫자 조합 찾고 소수면 set에 추가
    public static void dfs(String str, int idx) {

        if (str != "") {
            int num = Integer.parseInt(str);
            if (isPrime(num)) set.add(num); // 소수 판별
        }

        if (idx == arr.length) return; // 탈출 조건

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue; // 방문한 노드면 넘어감

            visited[i] = true; // 방문 체크

            dfs(str + arr[i], idx + 1); // 방문 안했을 시 재귀

            visited[i] = false; // 백트래킹 (재방문 위해)
        }
    }

    // 소수 판별
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

//        System.out.println(number);

        return true;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String number = br.readLine();

        System.out.println(solution(number));
    }
}
