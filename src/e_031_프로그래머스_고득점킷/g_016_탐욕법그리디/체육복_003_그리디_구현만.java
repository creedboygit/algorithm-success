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
public class 체육복_003_그리디_구현만 {

    public static int solution(int n, int[] lostArr, int[] reserveArr) {

        // 1. 정답 초기화
//        int answer = n - lostArr.length;
//        int answer = 0;
        int count = 0;

        // 2. 배열 정렬
        Arrays.sort(lostArr);
        Arrays.sort(reserveArr);

        // 3. 여벌이 있는 학생이 도난 당한 경우를 먼저 처리
        // 여벌이 있는 학생이 도난당한 경우
        for (int i = 0; i < lostArr.length; i++) {
            loop: for (int j = 0; j < reserveArr.length; j++) {
                // 자기 자신이 포함되어 있는지 체크
                if (lostArr[i] == reserveArr[j]) {
                    count++; // 자신의 옷을 입으면 되니까 참여자 수 증가
                    lostArr[i] = -1;
                    reserveArr[j] = -1;
                    break loop;
                }
            }
        }

        // 4. 체육복 빌려주는 경우 처리
        for (int i = 0; i < lostArr.length; i++) {
            loop: for (int j = 0; j < reserveArr.length; j++) {
                // 잃어버린 사람거보다 1 작거나 큰거 가능하니까
//                if (lostArr[i] - 1 == reserveArr[j] || lostArr[i] + 1 == reserveArr[j]) {
                if (lostArr[i] == reserveArr[j] - 1 || lostArr[i] == reserveArr[j] + 1) {
//                    answer++;
                    count++;
                    reserveArr[j] = -1;
                    break loop;
                }
            }
        }

        //결과값 : 전체 학생수 - 잃어버린 학생 수 + 빌린 학생 수
        return n - lostArr.length + count;
//        return answer;
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
