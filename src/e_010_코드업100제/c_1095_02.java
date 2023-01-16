package e_010_코드업100제;

import java.util.Arrays;
import java.util.Scanner;

/*
11
10 4 2 3 6 6 7 9 8 5 1
 */

public class c_1095_02 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }

        Arrays.sort(num);

        System.out.println(num[0]);
    }
}
