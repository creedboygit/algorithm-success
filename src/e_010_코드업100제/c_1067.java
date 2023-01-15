package e_010_코드업100제;

import java.util.Scanner;

//-2147483648

public class c_1067 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();

        if (a < 0)
            System.out.println("minus");
        else
            System.out.println("plus");

        if (a % 2 == 0)
            System.out.println("even");
        else
            System.out.println("odd");

        sc.close();
    }
}
