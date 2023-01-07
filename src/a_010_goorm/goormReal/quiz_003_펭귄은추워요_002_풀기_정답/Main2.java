package a_010_goorm.goormReal.quiz_003_펭귄은추워요_002_풀기_정답;

import java.util.Scanner;

/*
4 7 9

1
2

-------------

1 2 3

0
0

--------------

5 6 10

2
3

---------
1 5 10

2
4
맞나?? (최대는 맞는거 같은데 최소는 어떻게 해결해야 하나?)

-------------
1 7 8

2
5
맞나?? (최대는 맞는거 같은데 최소는 어떻게 해결해야 하나?)

----------------------
2 5 10

2
4
맞나?? (최대는 맞는거 같은데 최소는 어떻게 해결해야 하나?)

-------------


풀이 힌트
https://plplim.tistory.com/45

풀어봤는데 맞는지는 모르겠다.
일단 위에 샘플대로는 나온다.
 */

public class Main2 {

    public int[] solution(int left, int middle, int right) {

        int[] answer = new int[2]; // 최소값, 최대값 구하기 위한 초기화

        int leftSide, rightSide;

        leftSide = middle - left;
        rightSide = right - middle;


        // 연속된 숫자면 0, 0 반환
        if (leftSide == 1 && rightSide == 1) {
            answer[0] = 0;
            answer[1] = 0;

            return answer;
        }

        int fixPosition_min = Math.min(leftSide, rightSide);
        int fixPosition_max = Math.max(leftSide, rightSide);

        // 최소값 구하기
        if (fixPosition_min == 2) {
            answer[0] = 1;
        } else if (fixPosition_min == 1 || fixPosition_min >= 3) {
            answer[0] = 2;
        }

        // 최대값 구하기
        answer[1] = fixPosition_max - 1;

        return answer;
    }


    public static void main(String[] args) throws Exception {

        Main2 t = new Main2();

        Scanner sc = new Scanner(System.in);
        int left = sc.nextInt();
        int middle = sc.nextInt();
        int right = sc.nextInt();

        for (int answer : t.solution(left, middle, right)) {
            System.out.println(answer);
        }
    }
}
