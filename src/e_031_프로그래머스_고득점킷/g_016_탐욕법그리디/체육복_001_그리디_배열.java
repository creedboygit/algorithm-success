package e_031_프로그래머스_고득점킷.g_016_탐욕법그리디;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42862

5	[2, 4]	[1, 3, 5]
정답 : 5

5	[2, 4]	[3]
정답 : 4

3	[3]	[1]
정답 : 2

5
2 4
1 3 5
정답 : 5

5
2 4
3
정답 : 4
 */

import java.io.*;
import java.util.Arrays;

//Solution
public class 체육복_001_그리디_배열 {

    public static int solution(int n, int[] lostArr, int[] reserveArr) {

        // 1. student 배열 생성
        int[] student = new int[n + 2]; // 앞뒤로 빌려줘야 하므로 여분으로 앞 0, 뒤 6을 위해 2개를 추가해줌 (소스를 깔끔하게 하기 위해)
        int answer = 0;

        Arrays.sort(lostArr); // 꼭 정렬해줘야 한다.
        Arrays.sort(reserveArr); // 꼭 정렬해줘야 한다.

        // 2. reserve / lost 정보 반영
        for (int l : lostArr)
            student[l]--;

        for (int r : reserveArr)
            student[r]++;

        // 3. 여분을 기준으로 앞뒤를 확인하여 체육복을 빌려준다.
        // -1 : 도난당한 학생 / 0 : 본인것만 가지고 있는 학생 / 1 : 여분을 가지고 있는 학생
        for (int i = 1; i <= n; i++) {
            if (student[i] == 1) { // i번째 학생이 여분의 체육복을 가지고 있다면
                if (student[i - 1] == -1) { // 앞 학생이 도난당한 학생일 경우
                    student[i]--;
                    student[i - 1]++;
                } else if (student[i + 1] == -1) { // 뒤 학생이 도난당한 학생일 경우
                    student[i]--;
                    student[i + 1]++;
                }
            }
        }

        // 4. 체육복을 가지고 있는 학생수를 구한다.
        for (int i = 1; i <= n; i++) {
            if (student[i] >= 0)
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] lostStr = br.readLine().split(" ");
        int[] lostArr = new int[lostStr.length];
        for (int i = 0; i < lostArr.length; i++) {
            lostArr[i] = Integer.parseInt(lostStr[i]);
        }

        String[] reserveStr = br.readLine().split(" ");
        int[] reserveArr = new int[reserveStr.length];
        for (int i = 0; i < reserveArr.length; i++) {
            reserveArr[i] = Integer.parseInt(reserveStr[i]);
        }

//        System.out.println(Arrays.toString(lostArr));
//        System.out.println(Arrays.toString(reserveArr));

        System.out.println(solution(n, lostArr, reserveArr));
    }
}
