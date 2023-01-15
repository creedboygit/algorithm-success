package e_010_코드업100제;

import java.util.Scanner;

//75254

public class c_1025_02 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] b = String.valueOf(n).split("");

        int[] c = new int[b.length];

        for (int i = 0; i < b.length; i++) {
            c[i] = Integer.parseInt(b[i]);
        }

        System.out.printf("[%d]\n[%d]\n[%d]\n[%d]\n[%d]", c[0] * 10000, c[1] * 1000, c[2] * 100, c[3] * 10, c[4]);

        sc.close();
    }
}
