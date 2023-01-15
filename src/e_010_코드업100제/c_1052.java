package e_010_코드업100제;

import java.util.Scanner;

//0 1

public class c_1052 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();

        System.out.println(a != b ? 1 : 0);

        sc.close();
    }
}
