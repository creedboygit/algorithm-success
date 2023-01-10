package e_010_codeup100;

import java.util.Arrays;
import java.util.Scanner;

//Informatics

public class c_1021 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        char[] c = s.toCharArray();

        for (char i : c) {
            System.out.print(i);
        }

        sc.close();
    }
}
