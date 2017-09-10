package jingdong.p1;

import java.util.Scanner;

/**
 * Created by shugenniu on 2017/9/8.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            long n = scanner.nextLong();
            System.out.println(resolve(n));
        }
    }

    public static long resolve(long num) {
        if (num == 1) {
            return 1;
        }
        long res = (long) Math.pow(2 * (num +1), 0.5);
        long tmpRes = res+1;
        if((tmpRes *tmpRes-tmpRes)/2 +1 == num) {
            return tmpRes;
        }
        return res;
    }
}
