package e_010_코드업100제;

import java.util.Scanner;

/*
57
10
 */

public class c_1087_002 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();

        int sum = 0;

        for (int i = 1; i <= h; i++) {

            sum += i;

            if (sum >= h) {
                System.out.println(sum);
                break;
            }
        }
    }
}
