package e_010_코드업100제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c_1014_03 {

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s, " ");

        char a = st.nextToken().charAt(0);
        char b = st.nextToken().charAt(0);

//        System.out.println(b + " " + a);
        System.out.printf("%c %c", b, a);
    }
}
