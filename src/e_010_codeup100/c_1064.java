package e_010_codeup100;

import java.util.Scanner;

//3 -1 5

public class c_1064 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();

//        System.out.println(a > b ? a : b);

        long d = Math.min(a, b);
        long e = Math.min(d, c);

        System.out.println(e);

        sc.close();
    }
}
