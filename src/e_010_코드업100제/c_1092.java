package e_010_코드업100제;

import java.util.Scanner;

/*
3 7 9
 */

public class c_1092 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        long a = sc.nextInt();
        long m = sc.nextInt();
        long d = sc.nextInt();

        long day = 1;

//        while (true) {
//
//            if (day % a == 0 && day % m == 0 && day % d == 0) {
//
//                System.out.println(day);
//                break;
//            }
//
//            day++;
//        }

        while (day % a != 0 || day % m != 0 || day % d != 0) {

            day++;
        }

        System.out.println(day);
    }
}
