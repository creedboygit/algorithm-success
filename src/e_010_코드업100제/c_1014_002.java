package e_010_코드업100제;

import java.util.Scanner;

public class c_1014_002 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        char a = sc.next().charAt(0);
        char b = sc.next().charAt(0);

//        System.out.println(b + " " + a);
        System.out.printf("%c %c", b, a);

        sc.close();
    }
}
