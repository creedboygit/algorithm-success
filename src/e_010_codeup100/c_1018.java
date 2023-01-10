package e_010_codeup100;

import java.util.Scanner;

//3:16

public class c_1018 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(":");

        int h = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        System.out.printf("%d:%d", h, m);

        sc.close();
    }
}
