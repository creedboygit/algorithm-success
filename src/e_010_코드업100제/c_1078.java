package e_010_코드업100제;

import java.util.Scanner;

/*
4
 */

public class c_1078 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sum = 0;

//        for (int i = 1; i <= n; i++) {
        for (int i = 2; i <= n; i++) { // 어차피 짝수여야 하니까 2부터 시작해도 되지 (조금이라도 부하를 줄여야 한다.)
            if (i % 2 == 0) sum += i;
        }

        System.out.println(sum);

        sc.close();
    }
}
