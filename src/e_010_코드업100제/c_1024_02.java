package e_010_코드업100제;

import java.util.Scanner;

//Boy

public class c_1024_02 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        String[] arr = s.split("");

        for (String c : arr) {
            System.out.println("\'" + c + "\'");
        }

        sc.close();
    }
}
