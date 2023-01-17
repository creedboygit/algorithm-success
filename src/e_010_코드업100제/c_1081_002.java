package e_010_코드업100제;

import java.io.*;
import java.util.StringTokenizer;

/*
2 3
 */

public class c_1081_002 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                System.out.println(i + " " + j);

        br.close();
    }
}
