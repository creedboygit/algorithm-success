package a_004_기존문제풀기.q_007_개취_겹치는선분의길이_배열;

public class Solution {

    public int solution(int[][] lines) {

        // 1. arr 배열 및 변수 초기화
        int answer = 0;
        int[] arr = new int[200];

        // 2. lines 정보를 arr 배열에 적용
        for (int i = 0; i < lines.length; i++)

            // 문제에서 음수부터 들어가므로 음수를 고려하기 위해 문제에서의 -100 ~ 100 을 1 ~ 100으로 만들어주기 위해 100을 더함
            for (int j = lines[i][0] + 100; j < lines[i][1] + 100; j++)
                arr[j]++;

        // 3. arr 배열에서 겹친 부분 세기
        for (int i = 0; i < 200; i++)
            if (arr[i] > 1)
                answer++;

        return answer;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

//        int arr[][] = {{0, 1}, {2, 5}, {3, 9}};
        int arr[][] = {{0, 5}, {3, 9}, {1, 10}};

        System.out.println(sol.solution(arr));
    }
}
