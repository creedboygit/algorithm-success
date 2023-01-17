package e_010_코드업100제;

import java.util.Scanner;

/*
44100 16 2 10
 */

public class c_1085_002 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        double h = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double s = sc.nextDouble();

        double answer = 1;
        answer = h * b * c * s;
        answer /= 8;
        answer /= 1024;
        answer /= 1024;

        System.out.printf("%.1f MB", answer);
    }
}
