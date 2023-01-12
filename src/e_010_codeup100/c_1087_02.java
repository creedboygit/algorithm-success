package e_010_codeup100;

import java.util.Scanner;

/*
57
10
 */

public class c_1087_02 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();

        int n = 1;
        int sum = 0;
        int answer = 0;

        for (int i = 1; i <= h; i++) {

            sum += i;

            if (sum >= h) {
                System.out.println(sum);
                break;
            }
        }
    }
}
