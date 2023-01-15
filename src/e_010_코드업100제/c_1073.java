package e_010_코드업100제;

import java.util.Scanner;

/*
7 4 2 3 0 1 5 6 9 10 8
 */

public class c_1073 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int a;
        while (true) {
            a = sc.nextInt();

            if (a == 0)
                break;
            else
                System.out.println(a);
        }

        sc.close();
    }
}
