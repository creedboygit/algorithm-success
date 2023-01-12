package e_010_codeup100;

import java.util.Scanner;

//7 4 2 3 0 1 5 6 9 10 8

public class c_1071_02 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        String[] arr = sc.nextLine().split(" ");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("0")) {
                break;
            } else {
                System.out.println(arr[i]);
            }
        }

        sc.close();
    }
}
