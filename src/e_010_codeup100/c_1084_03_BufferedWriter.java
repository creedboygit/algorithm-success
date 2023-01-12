package e_010_codeup100;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
2 2 2
1 2 3
 */

public class c_1084_03_BufferedWriter {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int sum = 0;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {

                String result = "";

                for (int u = 0; u < t; u++) {

                    result += i + " " + j + " " + u + "\n";
                    sum++;
                }

                bw.write(result);
                bw.flush();
            }

        System.out.print(sum);
//        bw.write(Integer.toString(n * m * t));
        bw.close();
        br.close();
    }
}