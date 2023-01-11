package e_010_codeup100;

import java.util.Scanner;

//17:00:57

public class c_1026 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        String data = sc.nextLine();

        String[] arr = data.split(":");

        int min = Integer.parseInt(arr[1]);

//        System.out.println(arr[1]);

        System.out.printf("%d", min);


        sc.close();
    }
}
