package e_010_코드업100제;

import java.util.Scanner;

//Boy

public class c_1024_03 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        for (int i = 0; i < s.length(); i++) {
            System.out.printf("\'%s\'\n", s.charAt(i));
        }

        sc.close();
    }
}
