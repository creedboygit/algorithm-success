package e_010_코드업100제;

import java.util.Scanner;

//1 2 8

public class c_1066 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();

        if (a % 2 == 0)
            System.out.println("even");
        else
            System.out.println("odd");

        if (b % 2 == 0)
            System.out.println("even");
        else
            System.out.println("odd");

        if (c % 2 == 0)
            System.out.println("even");
        else
            System.out.println("odd");

        sc.close();
    }
}
