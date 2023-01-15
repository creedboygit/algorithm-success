package e_010_코드업100제;

import java.util.Scanner;

//2013.8.5

public class c_1019 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split("\\.");

        int y = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int d = Integer.parseInt(s[2]);

        System.out.printf("%04d.%02d.%02d", y, m, d);

        sc.close();
    }
}
