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
import java.util.StringTokenizer;

//Solution
public class 소수찾기_001_완전탐색_개취 {

    static HashSet<Integer> numberSet = new HashSet<>(); // 중복값 제거 위한 set

    public static boolean isPrime(int number) {
        // 1. 0과 1은 소수가 아니다.
        if (number == 0 || number == 1) {
            return false;
        }

        // 2. 에라토스테네스의 체의 limit 숫자를 계산한다.
        int limit = (int) Math.sqrt(number);

        // 3. 에라토스테네스의 체에 따라 limit 까지 배수 여부를 확인한다.
        for (int i = 2; i <= limit; i++) {
            if (number % i == 0)
                return false;
        }

//        System.out.println(number);

        return true;
    }

    public static void dfs(String comb, String others) {

//        System.out.println("comb : " + comb);

        // 1. 현재 조합을 set에 추가한다.
        if (!comb.equals("")) // 맨 처음이라면
            numberSet.add(Integer.valueOf(comb));

        // 2. 남은 숫자 중 한 개를 더해 새로운 조합을 만든다. (재귀 함수에 다음 값을 던진다.)
        for (int i = 0; i < others.length(); i++)
            dfs(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));

    }

    public static int solution(String number) {

        // 1. 모든 조합의 숫자를 만든다. (재귀 함수 이용)
        dfs("", number); // dfs 초기화

        // 2. 소수의 개수만 센다.
        int count = 0;
        Iterator<Integer> it = numberSet.iterator();

        while (it.hasNext()) {
            int num = it.next();

            if (isPrime(num))
                count++;
        }

        // 3. 소수의 개수를 반환한다.
        return count;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String number = br.readLine();

        System.out.println(solution(number));
    }
}
