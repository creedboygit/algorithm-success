package e_010_코드업100제;

import java.util.Scanner;

//1 2 8

public class c_1066_002 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        String[] arr = sc.nextLine().split(" ");

        for (int i = 0; i < arr.length; i++) {

            int c = Integer.parseInt(arr[i]);

            if (c % 2 == 0)
                System.out.println("even");
            else
                System.out.println("odd");
        }

        sc.close();
    }
}
