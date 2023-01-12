package e_010_codeup100;

import java.util.Scanner;

/*
x b k d l q g a c
 */

public class c_1079 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        String[] arr = sc.nextLine().split(" ");

        for (int i = 0; i <= arr.length; i++) {

            if (arr[i].equals("q")) {
                System.out.println(arr[i]);
                break;
            }

            System.out.println(arr[i]);
        }

        sc.close();
    }
}
