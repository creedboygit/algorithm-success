package e_010_코드업100제;

import java.util.Scanner;

//2014.07.15

public class c_1027 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        String data = sc.nextLine();

        String[] arr = data.split("\\.");

        String str = arr[2] + "-" + arr[1] + "-" + arr[0];

//        System.out.println(str);

        System.out.printf("%s-%s-%s", arr[2], arr[1], arr[0]);


        sc.close();
    }
}
