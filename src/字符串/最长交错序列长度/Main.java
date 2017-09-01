package 字符串.最长交错序列长度;

import java.util.Scanner;

/**
 * Created by shugenniu on 2017/8/31.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] ints = new int[n];
            for (int i = 0; i < n; i++) {
                ints[i] = scanner.nextInt();
            }
            int tmp = 1, maxnum = 0;
            for (int i = 1; i < ints.length; i++) {
                if (ints[i] != ints[i - 1]) {
                    tmp++;
                }
                if (tmp > maxnum) {
                    maxnum = tmp;
                }
            }
            System.out.println(maxnum);
        }
        scanner.close();
    }
}
