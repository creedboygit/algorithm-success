package e_010_코드업100제;

import java.util.Scanner;

//75254

public class c_1025_003 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        String str = "0";

        str = "1" + str.repeat(s.length() - 1);

        int a = Integer.parseInt(str);

        for (int i = 0; i < s.length(); i++) {
            System.out.println("[" + (s.charAt(i) - '0') * a + "]");
            a /= 10;
        }

        sc.close();
    }
}
