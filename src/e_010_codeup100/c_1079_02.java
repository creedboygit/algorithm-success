package e_010_codeup100;

import java.util.Scanner;

/*
x b k d l q g a c
 */

public class c_1079_02 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        while (true) {

            char c = sc.next().charAt(0);

            System.out.println(c);
            if (c == 'q') break;
        }

        sc.close();
    }
}
