package e_031_프로그래머스_고득점킷.g_016_탐욕법그리디;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42883

1924 2
정답 : 94

1231234 3
정답 : 3234

4177252841 4
정답 : 775841
 */

// number.length() - k 자리수만큼 구해야 한다.
// 자리수가 n이라고 치면, 뒤에서 n-1개 만큼 빼고 앞에서 최댓값을 구한다.
// 답에 추가하고, 그 index 기준으로 남은 자리수만큼 빼놓고 최대값을 구한다.
// + 시간때문에 StringBuilder사용하자

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//Solution
public class 큰수만들기_004_그리디_스택 {

    public static String solution(String number, int k) {

        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i); // 1924에 직접 접근

            // stack이 비어있지 않고 stack에 있는 게 현재 위치의 수보다 작고 k--한게 0보다 크면
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop(); // 맨 위에거를 뽑는다.
            }

            // 위의 상황이 아니라면 stack에 넣는다.
            stack.push(c);
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }

//        return String.valueOf(result);
        return new String(result);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String number = st.nextToken();
        int k = Integer.parseInt(st.nextToken());

        System.out.println(solution(number, k));
    }
}
