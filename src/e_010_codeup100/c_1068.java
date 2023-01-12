package e_010_codeup100;

import java.util.Scanner;

//73

public class c_1068 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();

        if (a >= 90 && a <= 100)
            System.out.println("A");
        else if(a >= 70 && a <= 90)
            System.out.println("B");
        else if(a >= 40 && a <= 69)
            System.out.println("C");
        else if(a >= 0 && a <= 39)
            System.out.println("D");

        sc.close();1
    }
}
