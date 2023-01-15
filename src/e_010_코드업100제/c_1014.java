package e_010_코드업100제;

import java.util.Scanner;

public class c_1014 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

//        char c = sc.next().charAt(0);
//        System.out.println(c);

        String[] x = sc.nextLine().split(" ");
        char a = x[0].charAt(0);
        char b = x[1].charAt(0);

//        System.out.println(b + " " + a);
        System.out.printf("%c %c", b, a);

        sc.close();
    }
}
