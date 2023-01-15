package e_010_코드업100제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
2 2 2
1 2 3
 */

public class c_1084_02_BufferedWriter {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int sum = 0;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                for (int u = 0; u < t; u++) {

                    String str = i + " " + j + " " + u;

                    bw.write(str + "\n");
//                    bw.flush();

//                    sum++;
                }

//        System.out.print(sum);
        bw.write(Integer.toString(n * m * t));
        bw.close();
        br.close();
    }
}