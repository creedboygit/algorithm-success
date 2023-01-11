package e_010_codeup100;

import java.util.Scanner;

//f

public class c_1035 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        String n = sc.next();

        int m = Integer.parseInt(n, 16);
        String x = Integer.toOctalString(m);

        System.out.print(x);

        sc.close();
    }
}
