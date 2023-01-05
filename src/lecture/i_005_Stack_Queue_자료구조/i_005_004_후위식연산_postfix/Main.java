package lecture.i_005_Stack_Queue_자료구조.i_005_004_후위식연산_postfix;

import java.util.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72748?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/05-04

/*
4. 후위식 연산(postfix)
설명

후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.

만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.


입력
첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다.

식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.


출력
연산한 결과를 출력합니다.
*/

/*
입력
352+*9-

출력
12
*/

    public int solution(String str) {

        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (char x : str.toCharArray()) {

            if (Character.isDigit(x)) {
                stack.push(x - 48); // 아스키코드 0이 48이므로 문자 - 48을 해줘야 한다. 까먹지 말자
            } else {
                int rt = stack.pop();
                int lt = stack.pop();
                if (x == '+') stack.push(lt + rt);
                else if (x == '-') stack.push(lt - rt);
                else if (x == '*') stack.push(lt * rt);
                else if (x == '/') stack.push(lt / rt);
            }
        }

        answer = stack.get(0);

        return answer;
    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(t.solution(str));
    }
}
