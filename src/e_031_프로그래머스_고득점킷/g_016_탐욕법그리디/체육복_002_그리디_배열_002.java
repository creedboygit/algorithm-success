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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//Solution
public class 체육복_002_그리디_배열_002 {

    public static int solution(int n, int[] lostArr, int[] reserveArr) {

        int answer = 0;

        // 1. student 배열 생성
        // 밑에 비교하는 반복문에서 0이나 n에서 앞뒤학생비교시
        // 값이 없으면 Out of Index에러나옴, 이를 피하기 위해 n+2로 만든다.
        int[] student = new int[n + 2]; // 앞뒤로 빌려줘야 하므로 여분으로 앞 0, 뒤 6을 위해 2개를 추가해줌 (소스를 깔끔하게 하기 위해)

        Arrays.sort(lostArr); // 꼭 정렬해줘야 한다.
        Arrays.sort(reserveArr); // 꼭 정렬해줘야 한다.

        // 일단 모든 학생이 체육복을 가져온 것으로 한다.
        Arrays.fill(student, 1);
        student[0] = student[n + 1] = 0;

        // reserve 학생들 +1
        for (int i = 0; i < reserveArr.length; i++) student[reserveArr[i]]++;

        // lost 학생들 -1
        for (int i = 0; i < lostArr.length; i++) student[lostArr[i]]--;

        // 체육복없는 학생들 빌려주기
        for (int i = 1; i <= n; i++) {
            if (student[i] == 0) {
                //앞 학생이 여벌있을 때
                if (student[i - 1] == 2) {
                    student[i - 1]--;
                    student[i]++;

                    //뒤 학생이 여벌있을 때
                } else if (student[i + 1] == 2) {
                    student[i + 1]--;
                    student[i]++;
                }
            }
        }

        //체육복 가지고 있는 학생 수 세기
        for (int i = 1; i <= n; i++)
            if (student[i] != 0) answer++;

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
