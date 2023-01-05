package a_004_기존문제풀기.q_011_개취_전구_백준_DP;

import java.util.*;

public class Main {

    final static int INF = Integer.MAX_VALUE;
//    final static int INF = 1 << 30;

    static int[] a;
    static int[][] dp;

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

//        System.out.println(INF);

        // 0. 입력 받으며 중복 숫자 제거
        int N = sc.nextInt();
        int K = sc.nextInt();

        a = new int[N + 1];
        dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            a[i] = sc.nextInt();
            if (a[i] == a[i - 1]) {
                N--;
                i--;
            }
        }

        // 1. dp 배열 초기화 : i 부터 j 까지의 전구를 하나로 통일하기 위한 최소 변경 수
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++)
                dp[i][j] = INF;

            dp[i][i] = 0; // i부터 i까지의 전구를 하나로 통일하기 위한 변경의 수 (대각선의 경우는 모두 0으로 초기화)
        }

        // 2. 두 개 이상의 전구들 간의 최소값 계산
        for (int size = 2; size <= N; size++) {

            for (int start = 1; start <= N - size + 1; start++) {
                int end = start + size - 1;

                for (int mid = start; mid < end; mid++) {
                    int newValue = dp[start][mid] + dp[mid+1][end];
                    if (a[start] != a[mid + 1])
                        newValue++;
                    if (dp[start][end] > newValue)
                        dp[start][end] = newValue;

//                    dp[start][end] = Math.min(dp[start][end],
//                            dp[start][mid] + dp[mid + 1][end] +
//                                    (a[start != a[mid + 1] ? 1 : 0]));
                }
            }
        }

        System.out.println(dp[1][N]);
        sc.close();
    }
}
