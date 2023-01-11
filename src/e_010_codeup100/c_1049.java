package e_010_codeup100;

import java.util.Scanner;

//9 1

public class c_1049 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long m = sc.nextLong();

        int a = 0;

        if (n > m)
            a = 1;

//        System.out.println(a);
        System.out.println(n > m ? 1 : 0);

        sc.close();
    }
}
