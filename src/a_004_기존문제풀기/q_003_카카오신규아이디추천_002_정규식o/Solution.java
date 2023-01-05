package a_004_기존문제풀기.q_003_카카오신규아이디추천_002_정규식o;

// 정규식 이용

import java.util.*;

public class Solution {

    public String solution(String new_id) {

        // 1단계
        String answer = "";
        new_id = new_id.toLowerCase();

        // 2단계
        answer = new_id.replaceAll("[^a-z0-9-_.]", "");

        // 3단계
        answer = answer.replaceAll("\\.+", ".");

        // 4단계
        answer = answer.replaceAll("^[.]|[.]$", "");

        // 5단계
        if (answer.isEmpty())
            answer = "a";

        // 6단계
        if (answer.length() > 15) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }

        // 7단계
        while (answer.length() < 3) {
            answer += answer.charAt(answer.length() - 1);
        }

        return answer;
    }


    public static void main (String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("...!@BaT#*..y.abcdefghijklm"));
    }
}
