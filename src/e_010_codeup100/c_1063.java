package e_010_codeup100;

import java.util.Scanner;

//123 456

public class c_1063 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();

//        System.out.println(a > b ? a : b);

        System.out.println(Math.max(a, b));

        sc.close();
    }
}
