package e_010_codeup100;

import java.util.Scanner;

//73

public class c_1069 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        char a = sc.nextLine().charAt(0);
        String str;

        switch (a) {
            case 'A' :
                str = "best!!!";
                break;
            case 'B' :
                str = "good!!";
                break;
            case 'C' :
                str = "run!";
                break;
            case 'D' :
                str = "slowly~";
                break;
            default :
                str = "what?";
                break;
        }

        System.out.println(str);

        sc.close();
    }
}
