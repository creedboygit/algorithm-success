package a_010_goorm.goormReal.quiz_003_펭귄은추워요_002_풀기;

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

public class Main {

    private static int findFixPosition_min(int left, int middle, int right) {
        return right - middle > middle - left ? left : right;
    }

    private static int findFixPosition_max(int left, int middle, int right) {
        return right - middle > middle - left ? right : left;
    }

    public int[] solution(int left, int middle, int right) {

        int[] answer = new int[2];

        if (middle - left == 1 && right - middle == 1) {
            answer[0] = 0;
            answer[1] = 0;

            return answer;
        };

//        if (middle - left == 1 || right - middle == 1) {
//            middle = middle + 1;
//        }

        int fixPosition_min = findFixPosition_min(left, middle, right);
        int fixPosition_max = findFixPosition_max(left, middle, right);

        int a = Math.abs(middle - fixPosition_min);

        if (a == 2) {
            answer[0] = 1;
        } else if (a == 1 || a >= 3) {
            answer[0] = 2;
        }


//        answer[0] = Math.abs(fixPosition - middle) - 2; // 최소값 틀렸음
        answer[1] = Math.abs(fixPosition_max - middle) - 1;

        return answer;
    }

//    public void dfs(int n, int m, int k) {
//
//        if (n == ) {
//
//        }
//
//    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();

        Scanner sc = new Scanner(System.in);
        int left = sc.nextInt();
        int middle = sc.nextInt();
        int right = sc.nextInt();

        for (int answer : t.solution(left, middle, right)) {
            System.out.println(answer);
        }
    }
}
