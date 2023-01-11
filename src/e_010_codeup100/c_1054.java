package e_010_codeup100;

import java.util.Scanner;

//1

public class c_1054 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();

        if (a == 1 && b == 1)
            System.out.println("1");
        else
            System.out.println("0");

        sc.close();
    }
}
