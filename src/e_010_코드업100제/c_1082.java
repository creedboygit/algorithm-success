package e_010_코드업100제;

import java.util.*;

/*
B
 */

public class c_1082 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int x = Integer.parseInt(s, 16);

        for (int i = 1; i < 16; i++) {
            System.out.printf("%X*%X=%X\n", x, i, x * i);
        }

    }
}
