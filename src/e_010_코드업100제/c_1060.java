package e_010_코드업100제;

import java.util.Scanner;

//3 5

public class c_1060 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();

        System.out.printf("%d", a & b);


        sc.close();
    }
}
