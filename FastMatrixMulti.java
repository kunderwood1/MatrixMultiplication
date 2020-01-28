import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FastMatrixMulti {

    private static void FastMatrixMulti(int[] arr, int n) {
        int m[][] = new int[n][n];
        int s[][] = new int[n][n];
        int i, j, k, h, q;
        for (i = 1; i < n; i++)
            m[i][i] = 0;
        for (h = 2; h < n; h++) {
            for (i = 1; i < n - h + 1; i++) {
                j = i + h - 1;
                if (j != n) {
                    m[i][j] = Integer.MAX_VALUE;
                    for (k = i; k <= j - 1; k++) {
                        q = m[i][k] + m[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                        if (q < m[i][j]) {
                            m[i][j] = q;
                            s[i][j] = k;
                        }
                    }
                }
            }
        }
        printParenthesis(s, 1, s.length - 1);
        System.out.println("");
        System.out.println(m[1][n - 1]);
    }
    private static void printParenthesis(int[][] s, int i, int j) {
        if (i == j) {
            System.out.print("A" + i);
            return;
        }
        System.out.print("(");
        printParenthesis(s, i, s[i][j]);
        printParenthesis(s, s[i][j] + 1, j);
        System.out.print(")");
    }
    public static void main(String[] args) {
        try {
            File f = new File(args[0]);

            Scanner s1 = new Scanner(f);
            int count = 0;
            while (s1.hasNextInt()) {
                count++;
                s1.nextInt();
            }
            int[] arr = new int[count];
            Scanner s2 = new Scanner(f);
            for (int i = 0; i < count; i++) {
                arr[i] = s2.nextInt();
            }
            int size = arr.length;
            FastMatrixMulti(arr, size);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
