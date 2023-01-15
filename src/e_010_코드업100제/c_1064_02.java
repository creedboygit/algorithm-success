package e_010_코드업100제;

import java.util.Scanner;

//3 -1 5

public class c_1064_02 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();

//        System.out.println(a > b ? a : b);

        System.out.println((a > b ? b : a) > c ? c : (a > b ? b : a));

        sc.close();
    }
}
