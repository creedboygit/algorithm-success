package e_010_코드업100제;

import java.util.Scanner;

//000907-1121112

public class c_1020_02 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        String a = s.substring(0, 6);
        String b = s.substring(7);

        System.out.printf(a + b);

        sc.close();
    }
}
