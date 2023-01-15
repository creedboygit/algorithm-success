package e_010_코드업100제;

import java.util.Scanner;

//12

public class c_1070 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        String str = "";

        switch (a) {
            case 12:
            case 1:
            case 2:
                str = "winter";
                break;
            case 3:
            case 4:
            case 5:
                str = "spring";
                break;
            case 6:
            case 7:
            case 8:
                str = "summer";
                break;
            case 9:
            case 10 :
            case 11 :
                str = "fall";
                break;
            default :
                str = "error";
        }

        System.out.println(str);

        sc.close();
    }
}
