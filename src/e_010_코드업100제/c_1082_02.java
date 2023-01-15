package e_010_코드업100제;

import java.util.Scanner;

/*
B
 */

public class c_1082_02 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt(16);

        for (int i = 1; i < 16; i++) {
            System.out.printf("%X*%X=%X\n", x, i, x * i);
        }

    }
}
