package wangyi.p2;

import java.util.Scanner;

/**
 * Created by shugenniu on 2017/9/9.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            line = '#' + line;
            char[] chas = line.toCharArray();
            double total = 0;
            int count = 0, size = 0;
            //第0个是#
            for (int i = 1; i < chas.length; i++) {
                if (chas[i] != chas[i - 1]) {
                    total += count;
                    count = 1;
                    size++;
                } else {
                    count++;
                }
            }
            total += count;
            System.out.println(String.format("%.2f",total / size));
        }
    }
}
