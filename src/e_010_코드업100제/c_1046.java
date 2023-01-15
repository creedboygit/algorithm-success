package e_010_코드업100제;

import java.util.Scanner;

//1 2 3

public class c_1046 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long m = sc.nextLong();
        long c = sc.nextLong();

        System.out.println(n + m + c);
        System.out.printf("%.1f", (double)(n + m + c) / 3);

        sc.close();
    }
}
