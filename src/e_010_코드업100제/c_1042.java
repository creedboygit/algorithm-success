package e_010_코드업100제;

import java.util.Scanner;

//1 3
//4 2

public class c_1042 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long m = sc.nextLong();

        long a = n / m;

        System.out.print(a);

        sc.close();
    }
}
