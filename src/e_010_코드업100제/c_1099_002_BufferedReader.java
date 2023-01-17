package e_010_코드업100제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1 1 1 1 1 1 1 1 1 1
1 0 0 1 0 0 0 0 0 1
1 0 0 1 1 1 0 0 0 1
1 0 0 0 0 0 0 1 0 1
1 0 0 0 0 0 0 1 0 1
1 0 0 0 0 1 0 1 0 1
1 0 0 0 0 1 2 1 0 1
1 0 0 0 0 1 0 0 0 1
1 0 0 0 0 0 0 0 0 1
1 1 1 1 1 1 1 1 1 1


1 1 1 1 1 1 1 1 1 1
1 9 9 1 0 0 0 0 0 1
1 0 9 1 1 1 0 0 0 1
1 0 9 9 9 9 9 1 0 1
1 0 0 0 0 0 9 1 0 1
1 0 0 0 0 1 9 1 0 1
1 0 0 0 0 1 9 1 0 1
1 0 0 0 0 1 0 0 0 1
1 0 0 0 0 0 0 0 0 1
1 1 1 1 1 1 1 1 1 1
 */

public class c_1099_002_BufferedReader {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[][] board = new String[10][10];
        for (int i = 0; i < board.length; i++) {
            String[] line = bufferedReader.readLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                board[i][j] = line[j];
            }
        }

        int flag = 1;
        int end = 0;
        for (int i = 1; i < board.length; i++) {
            if (end != 1) {
                for (int j = flag; j < board[i].length; j++) {
                    if (board[i][j].equals("0")) {
                        board[i][j] = "9";
                    } else if (board[i][j].equals("2")) {
                        board[i][j] = "9";
                        end = 1;
                        break;
                    } else {
                        flag = j - 1;
                        break;
                    }
                }
            } else {
                break;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
