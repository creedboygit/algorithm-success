package e_031_프로그래머스_고득점킷.g_015_완전탐색;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42842

10	2	[4, 3]
8	1	[3, 3]
24	24	[8, 6]

10 2
정답 : 4 3

먼저, 위와 같이 가운데에 노란색 격자가 위치하기 위해서는 가로 세로가 3 이상이여야한다.
문제에서 요구하는 경우의 수를 찾으려면 일단 카펫 사이즈의 경우의 수를 구해야한다. ( 0 x 0 )
카펫 사이즈 경우의 수를 구하기 위해서 brown 격자 수 + yellow 격자 수의 약수를 구한다.
예를 들어, brown = 10,  yellow = 2 이라고 가정할 때, 12의 약수를 구한다 (1, 12) , (2, 6) , (3, 4) , (4, 3) , (6, 2) , (12, 1)
이렇게 구한 경우의 수 중에서 정답을 골라야 한다.
일단 가로의 길이가 세로보다 길거나 같다고 제한사항에 있으므로 경우의 수가 (4, 3) , (6, 2) , (12, 1)로 줄어든다.
또한, 가운데에 노란색 격자가 위치하기 위해선 가로, 세로 길이가 모두 3 이상이여야 하므로 (6, 2) , (12, 1)는 걸러진다.
마지막으로 해당 카펫이 입력으로 주어진 yellow의 개수만큼 노란색 격자가 가운데에 위치할 수 있는지 구해야한다.
(가로 - 2) * (세로 - 2 ) = yellow의 개수이므로 (4 - 2) * (3 - 1) = 2이다. 그러므로 정답.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//Solution
public class 카펫_001_완전탐색 {

    public static int[] solution(int brown, int yellow) {

        int[] answer = new int[2];

        int sum = brown + yellow; // 모두 합치면 전체 벽돌의 수가 된다.

        // 최소값 계산
        // yellow가 1개라면 최소 가로, 세로 모두 3 이상이어야 한다.

        // 예제처럼 sum이 12라면

        for (int i = 3; i < sum; i++) {
            int j = sum / i; // 약수 구하기

            if (sum % i == 0 && j >= 3) { // i와 j가 둘 다 약수이고 i와 j가 모두 3보다 크다면
                int col = Math.max(i, j); // 가로가 세로보다 길다고 했으므로
                int row = Math.min(i, j); // 가로가 세로보다 길다고 했으므로

                int center = (col - 2) * (row - 2); // 가운데는 맨 가에 쪽 2개를 뺀 것을 곱한 수

                if (center == yellow) {
                    answer[0] = col;
                    answer[1] = row;

                    return answer; // 답이 나오면 return
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int brown = Integer.parseInt(st.nextToken());
        int yellow = Integer.parseInt(st.nextToken());

        int[] result = solution(brown, yellow);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i] + " ");
        }
    }
}
