package e_010_codeup100;

import java.util.Scanner;

/*
f
 */

public class c_1076 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        char c = sc.nextLine().charAt(0);

        int chrs = (int) 'a';

        while (true) {

            if (chrs > (int) c)
                break;
            else
                System.out.println((char) chrs);

            chrs++;
        }

        sc.close();
    }
}
