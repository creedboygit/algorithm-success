package e_031_프로그래머스_고득점킷.g_018_DFS_BFS;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/43165

https://hyojun.tistory.com/entry/Programmers-%ED%83%80%EA%B2%9F-%EB%84%98%EB%B2%84-Java

[1, 1, 1, 1, 1]
3
5

5
1 1 1 1 1
3

[4, 1, 2, 1]
4
2

4
4 1 2 1
4
 */


import java.util.Scanner;

//Solution
public class 타겟넘버_DFS {

    static int[] numbers;
    static int target;
    static int answer;

    public static void dfs(int index, int sum) {

        // 1. 탈출 조건
        if (index == numbers.length) {
            if (sum == target) answer++;
            return;
        }

        // 2. 수행 동작
        dfs(index + 1, sum + numbers[index]);
        dfs(index + 1, sum - numbers[index]);
    }

    public static int solution(int[] a, int b) {

        answer = 0;

        numbers = a;
        target = b;

        dfs(0, 0);

        return answer;
    }

    public static void main(String[] args) {

//        타겟넘버_DFS s = new 타겟넘버_DFS();

        Scanner sc = new Scanner(System.in);

//        int[] a = {1, 1, 1, 1, 1};
//        int b = 3;

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int b = sc.nextInt();

        System.out.println(solution(a, b));

        sc.close();
    }
}
