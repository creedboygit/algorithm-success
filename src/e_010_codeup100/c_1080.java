package e_010_codeup100;

import java.util.Scanner;

/*
55
 */

public class c_1080 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int sum = 0;
        int m = 1;

        while (true) {

            sum += m;

            if (sum >= n) {
                break;
            }

            m++;
        }

        System.out.println(m);

        sc.close();
    }
}
