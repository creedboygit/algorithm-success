package a_004_기존문제풀기.q_001_완주하지못한선수_001_Sort이용;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/42576

// 배열의 sort를 이용하는 방법
public class Solution {

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        // 1. 두 배열을 정렬한다.
        Arrays.sort(participant);
        Arrays.sort(completion);

        // 2. 두 배열이 다를 때까지 찾는다.
        int i = 0;

        for (; i < completion.length; i++) { // 이렇게 int i를 이전에 초기화 해줘서 전역으로 만들면 아래에서 i가 2를 리턴해주게 된다.

//            System.out.println(participant[i] + " - " + completion[i]);

            if (!participant[i].equals(completion[i])) {
                break;
            }
        }

//        System.out.println(i);

        // 3. 여기까지 왔다면 마지막 주자가 완주하지 못한 선수이다.
        return participant[i];


    }

    public static void main(String[] args) throws Exception {
        String[] part = {"leo", "kiki", "eden"};
        String[] comp = {"leo", "kiki"};
        Solution sol = new Solution();
        System.out.println(sol.solution(part, comp));
    }
}

