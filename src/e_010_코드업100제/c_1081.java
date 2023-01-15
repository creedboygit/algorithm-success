package e_010_코드업100제;

import java.util.Scanner;

/*
2 3
 */

public class c_1081 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                System.out.println(i + " " + j);

        sc.close();
    }
}
