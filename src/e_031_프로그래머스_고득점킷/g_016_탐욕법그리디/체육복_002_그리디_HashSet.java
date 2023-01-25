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
import java.util.HashSet;

//Solution
public class 체육복_002_그리디_HashSet {

    public static int solution(int n, int[] lostArr, int[] reserveArr) {

        int answer = 0;

        // 1. Set을 만든다.
        HashSet<Integer> resList = new HashSet<>();
        HashSet<Integer> losList = new HashSet<>();

        for (int i : reserveArr) {
            resList.add(i);
        }

        for (int i : lostArr) {
            if (resList.contains(i)) {
                resList.remove(i);
            } else {
                losList.add(i);
            }
        }

        // 2. 여분을 기준으로 앞뒤를 확인하여 체육복을 빌려준다.
        // -1 : 도난당한 학생 / 0 : 본인것만 가지고 있는 학생 / 1 : 여분을 가지고 있는 학생
        for (int i : resList) {
            if (losList.contains(i - 1)) { // 앞 학생
                losList.remove(i - 1);
            } else if (losList.contains(i + 1)) { // 뒤 학생
                losList.remove(i + 1);
            }
        }

        // 3. 최대한 나눠준 후에 lost에 남아있는 학생들은 체육복이 없는 학생들이다.
        answer = n - losList.size();

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
