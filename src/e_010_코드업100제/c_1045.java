package e_010_코드업100제;

import java.util.Scanner;

//10 3

public class c_1045 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long m = sc.nextLong();

        System.out.println(n + m);
        System.out.println(n - m);
        System.out.println(n * m);
        System.out.println((int)(n / m));
        System.out.println(n % m);

//        float c = (float)n / m;
        double c = (double)n / m;
        System.out.printf("%.2f", c);

        sc.close();
    }
}
