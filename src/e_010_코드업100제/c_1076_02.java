package e_010_코드업100제;

import java.util.Scanner;

/*
f
 */

public class c_1076_02 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        char ch = sc.nextLine().charAt(0);

        int a = (int)ch;

        for (int i = 97; i <= a; i++) {
            System.out.printf("%c\n", i);
        }


        sc.close();
    }
}
