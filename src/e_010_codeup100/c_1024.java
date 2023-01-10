package e_010_codeup100;

import java.util.Scanner;

//Boy

public class c_1024 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        char[] arr = sc.nextLine().toCharArray();

        for (char c : arr) {
            System.out.println("\'" + c + "\'");
        }

        sc.close();
    }
}
