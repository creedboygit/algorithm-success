package e_010_codeup100;

import java.util.Scanner;

//75254

public class c_1025 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        String data = sc.nextLine();

        String[] arr = data.split("");

        System.out.printf("[%d]\n", Integer.parseInt(arr[0]) * 10000);
        System.out.printf("[%d]\n", Integer.parseInt(arr[1]) * 1000);
        System.out.printf("[%d]\n", Integer.parseInt(arr[2]) * 100);
        System.out.printf("[%d]\n", Integer.parseInt(arr[3]) * 10);
        System.out.printf("[%d]\n", Integer.parseInt(arr[4]));
        sc.close();
    }
}
