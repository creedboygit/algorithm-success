package e_010_codeup100;

import java.util.Scanner;

//1 3
//4 2

public class c_1042 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int a = n / m;

        System.out.print(a);

        sc.close();
    }
}
