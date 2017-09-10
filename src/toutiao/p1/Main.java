package toutiao.p1;

import java.util.Scanner;

/**
 * Created by shugenniu on 2017/9/10.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int c = scanner.nextInt();
            int row = n + 1;
            int col = c + 1;
            int[][] tb = new int[row][col];
            for (int i = 1; i < row; i++) {
                int num = scanner.nextInt();
                if (num == 0) {
                    continue;
                }
                //这里只是接受num个参数
                for (int j = 0; j < num; j++) {
                    tb[i][scanner.nextInt()] = 1;
                }
            }
            if(n==1) {
                System.out.println(0);
                continue;
            }
            //处理完输入，开始进行分析

            int total = 0;

            for (int i = 1; i < col; i++) {
                if(resolveSubProblem(tb,i,m)) {
                    total++;
                }
            }
            System.out.println(total);
        }
        scanner.close();
    }

    /**
     * 判断该颜色是否合法
     *
     * @param arr
     * @param c 哪种颜色
     * @param m
     * @return 返回true表示不合法
     */
    public static boolean resolveSubProblem(int[][] arr,int c ,int m) {
        int len = arr.length;
        int[] tmp = new int[2 * len - 1];
        for (int i = 1; i < len; i++) {
            tmp[i] = arr[i][c];
            tmp[len + i - 1] = arr[i][c];
        }

        for (int i = 1; i < len; i++) {
            if (sum(tmp, i, m) > 1) {
                return true;
            }
        }
        return false;

    }

    /**
     * 判断连续n个珠子，同一个颜色出现的次数
     *
     * @param data
     * @param start
     * @param len
     * @return
     */
    public static int sum(int[] data, int start, int len) {
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += data[start + i];
        }
        return sum;
    }


}
