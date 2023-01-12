package e_010_codeup100;

import java.util.Scanner;

/*
55
 */

public class c_1080_02 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sum = 0;

        for (int i = 1; i <= n; i++) {

            sum += i;

            if (sum >= n) {
                System.out.println(i);
                break;
            }
        }

        sc.close();
    }
}
