package e_010_codeup100;

import java.util.Arrays;
import java.util.Scanner;

/*
10
1 3 2 2 5 6 7 4 5 9
 */

public class c_1093 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        int[] arr2 = new int[24]; // 1부터니깐 배열의 개수 23 + 1 해줘야 한다.

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int j = 1; j <= 23; j++) {

            for (int k = 0; k < n; k++) {

                if (arr[k] == j) {
                    arr2[j]++;
                }
            }
        }

        for (int m = 1; m <= 23; m++) {
            System.out.print(arr2[m] + " ");
        }
    }
}
