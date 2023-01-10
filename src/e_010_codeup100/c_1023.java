package e_010_codeup100;

import java.util.Scanner;

//1.414213

public class c_1023 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String[] arr = s.split("\\.");

        System.out.println(arr[0]);
        System.out.println(arr[1]);

        sc.close();
    }
}
