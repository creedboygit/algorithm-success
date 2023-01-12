package e_010_codeup100;

import java.util.Scanner;

/*
44100 16 2 10
 */

public class c_1085 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        double h = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double s = sc.nextDouble();

        double answer = h * b * c * s;
        answer = (answer / 8) / 1024 / 1024;

        System.out.printf("%.1f MB", answer);
    }
}
