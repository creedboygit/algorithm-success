package e_010_codeup100;

import java.util.Scanner;

/*
10
1 3 2 2 5 6 7 4 5 9
 */

public class c_1093_03 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] num = new int[23]; // 1부터니깐 배열의 개수 23 + 1 해줘야 한다.

        for (int i = 0; i < n; i++) {
            int c = sc.nextInt();
            num[c - 1]++;
        }

        for (int x : num) {
            System.out.print(x + " ");
        }
    }
}
