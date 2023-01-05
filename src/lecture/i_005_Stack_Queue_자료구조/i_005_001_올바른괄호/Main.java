package lecture.i_005_Stack_Queue_자료구조.i_005_001_올바른괄호;

import java.util.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72745?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/05-01

/*
1. 올바른 괄호
설명

괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.

(())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.


입력
첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.


출력
첫 번째 줄에 YES, NO를 출력한다.
*/

/*
입력
(()(()))(()

(())()

((()))

출력
NO
*/

    public String solution(String str) {

        String answer = "YES";

        Stack<Character> stack = new Stack<>();

        for (char x : str.toCharArray()) {
            if (x == '(') stack.push(x); // 여는 괄호가 먼저 나와야 한다. 까먹지 말자
            else {
                if (stack.isEmpty()) return "NO";
                stack.pop();
            }
        }

        if (!stack.isEmpty()) return "NO"; // 최종적으로 비어있지 않을 때 NO다. 까먹지 말자

        return answer;
    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();

        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        String str = sc.next();

        System.out.println(t.solution(str));
    }
}
