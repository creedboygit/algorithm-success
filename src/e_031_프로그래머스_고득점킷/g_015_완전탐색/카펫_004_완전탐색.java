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

- 문제풀이를 위한 규칙들을 정리해봤습니다. 아래와 같습니다.

1. 행과 열의 갯수가 3이상이여야만 합니다.

그 이유는 yellow갯수가 최소 1일 경우에 brown의 행의 열과 갯수가 3이상이여야 하기때문입니다.



2. brown갯수와 yellow갯수를 합치면 return 갯수의 곱과 같습니다.

예시 1번의 brwon(10) 갯수와 yellow(2) 갯수를 더하면 12입니다.

12가 되는 경우는 (1,12) (2,6) (3,4) (4,3) (6,2) (12,1) 인데

행과 열의 갯수는 3이상이여야 하므로 (4,3)(3,4)가 남습니다.



3. "카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다."

문제의 조건에 의하면 답은 (4,3) 입니다.



4.  return 값의 가로-2 * 세로-2 = yellow

문제의 예시들을 분석해보면 위의 조건이 성립되어야만 합니다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Solution
public class 카펫_004_완전탐색 {

    public static int[] solution(int brown, int yellow) {

        int[] answer = new int[2];

        int total = brown + yellow; //전체 갯수

        //행과 열의 갯수는 3이상이여야 합니다.
        for (int i = 3; i <= total; i++) {

            if (total % i == 0) { // 세로의 약수가 되는 수 이어야 하기 때문에 나머지 0인 경우
                int a = total / i;
                int b = i;

                int row = Math.max(a, b); // 가로
                int col = Math.min(a, b); // 세로

                if ((row - 2) * (col - 2) == yellow) {
                    answer[0] = row;
                    answer[1] = col;

                    return answer;
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
