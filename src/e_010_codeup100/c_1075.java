package e_010_codeup100;

import java.util.Scanner;

/*
7
 */

public class c_1075 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

//        for (int i = n; i > 0; i--) {
//            System.out.println(i - 1);
//        }

//        int k = n - 1;

        while(n > 0) {
            System.out.println(--n);
//            n--;
        }

        sc.close();
    }
}
