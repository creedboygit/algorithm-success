package e_010_코드업100제;

import java.util.Scanner;

//13

public class c_1034_003 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        String x = sc.next();

        int a = Integer.valueOf(x, 8);

        System.out.print(a);

        sc.close();
    }
}
