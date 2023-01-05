package a_004_기존문제풀기.q_003_카카오신규아이디추천_001_정규식x;

import java.util.*;

// 일반
public class Solution {

    public String solution(String new_id) {

        // 1단계
        String answer = "";
        new_id = new_id.toLowerCase();

        // 2단계
        for (int i = 0; i < new_id.length(); i++) {
            char ch = new_id.charAt(i);
//            if (Character.isDigit(ch) || Character.isAlphabetic(ch) || ch == '-' || ch == '_' || ch == '.')
            if (Character.isLetterOrDigit(ch) || ch == '-' || ch == '_' || ch == '.')

                answer += ch;
        }

        // 3단계
        while (answer.indexOf("..") != -1) {
            answer = answer.replace("..", ".");
        }

        // 4단계
        if (!answer.isEmpty() && answer.charAt(0) == '.') {
            answer = answer.substring(1);
        }

        if (!answer.isEmpty() && answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }

        // 5단계
        if (answer.isEmpty()) {
            answer = "a";
        }

        // 6단계
        if (answer.length() > 15) {
            answer = answer.substring(0, 15);
            if (answer.charAt(answer.length() - 1) == '.') {
                answer = answer.substring(0, answer.length() - 1);
            }
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
