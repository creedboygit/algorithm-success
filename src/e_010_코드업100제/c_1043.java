package e_010_코드업100제;

import java.util.Scanner;

//10 3
//4 2

public class c_1043 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int a = n % m;

        System.out.print(a);

        sc.close();
    }
}
