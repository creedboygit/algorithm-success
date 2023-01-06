package a_010_goorm.goormReal.quiz_001_코딩과제;

import java.util.*;

/*
long형!
코딩테스트 오픈카톡방에서 힌트 얻음
 */

public class Main {

    public int solution(int n, int[] arr) {

        int answer = 0;

        return answer;
    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();


//        int x = n + 2;
//        int y = m + 2;

//        int z = Math.round(x * y / 4);

        long z = Long.valueOf(n * m);

        System.out.print(z);
    }
}
