package e_010_코드업100제;

import java.util.Scanner;

/*
1024 768 24
 */

public class c_1086_002 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        double h = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        double answer = 1;

        answer = (h * b * c) / 8 / 1024 / 1024;

        String answer2 = String.format("%.2f MB", answer);
        System.out.print(answer2);
    }
}
